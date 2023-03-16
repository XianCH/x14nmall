package com.x14nmall.cloud.auth.manager;


import cn.hutool.core.codec.Base64;
import cn.hutool.core.util.BooleanUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.StrUtil;
import com.x14nmall.cloud.api.auth.bo.UserInfoInTokenBO;
import com.x14nmall.cloud.api.auth.vo.TokenInfoVo;
import com.x14nmall.cloud.common.cache.constant.CacheNames;
import com.x14nmall.cloud.common.response.ServerResponseEntity;
import com.x14nmall.cloud.common.security.bo.TokenInfoBO;
import com.x14nmall.cloud.common.util.PrincipalUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.commons.util.IdUtils;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


/**
 * token管理
 * 1，登录返回token
 * 2，刷新token
 * 3，清楚用户过去的token
 * 4，校验token
 */
@Component
@RefreshScope
public class TokenStore {

    private static final Logger logger = LoggerFactory.getLogger(TokenStore.class);

    private final RedisTemplate<Object, Object> redisTemplate;

    private final RedisSerializer<Object> redisSerializer;

    private final StringRedisTemplate stringRedisTemplate;

    private int expiresIn = 3600;

    public TokenStore(RedisTemplate<Object, Object> redisTemplate, RedisSerializer<Object> redisSerializer, StringRedisTemplate stringRedisTemplate) {
        this.redisTemplate = redisTemplate;
        this.redisSerializer = redisSerializer;
        this.stringRedisTemplate = stringRedisTemplate;
    }

    /**
     * 将用户信息存到token中，并返回token信息
     */

    public TokenInfoBO storeAccessToken(UserInfoInTokenBO userInfoInToken) {
        TokenInfoBO tokenInfoBO = new TokenInfoBO();
        String accessToken = IdUtil.simpleUUID();
        String refreshToken = IdUtil.simpleUUID();

        tokenInfoBO.setAccessToken(accessToken);
        tokenInfoBO.setExpireIn(expiresIn);

        String uidToAccessKeyStr = getUidToAccessKey(getApprovalKey(userInfoInToken));
        String accessKeyStr = getAccessKey(accessToken);
        String refreshToAccessKeyStr = getRefreshToAccessKey(refreshToken);

        List<String> existAccessTokens = new ArrayList<>();
        existAccessTokens.add(accessToken + StrUtil.COLON + refreshToken);
        Long size = redisTemplate.opsForSet().size(uidToAccessKeyStr);
        if (size != null && size != 0) {
            List<String> tokenInfoBoList = stringRedisTemplate.opsForSet().pop(uidToAccessKeyStr, size);
            if (tokenInfoBoList != null) {
                for (String accessTokenWithRefreshToken : tokenInfoBoList) {
                    String[] accessTokenWithRefreshTokenArr = accessTokenWithRefreshToken.split(StrUtil.COLON);
                    String accessTokenData = accessTokenWithRefreshTokenArr[0];
                    if (BooleanUtil.isTrue(stringRedisTemplate.hasKey(getAccessKey(accessTokenData)))) {
                        existAccessTokens.add(accessTokenWithRefreshToken);
                    }
                }
            }
        }
        redisTemplate.executePipelined((RedisCallback<Object>) connection -> {
            long expiresIn = tokenInfoBO.getExpireIn();
            byte[] uidKey = uidToAccessKeyStr.getBytes(StandardCharsets.UTF_8);
            byte[] refreshKey = refreshToAccessKeyStr.getBytes(StandardCharsets.UTF_8);
            byte[] accessKey = accessKeyStr.getBytes(StandardCharsets.UTF_8);
            for (String existAccessToken : existAccessTokens) {
                connection.sAdd(uidKey, existAccessToken.getBytes(StandardCharsets.UTF_8));
            }
            connection.expire(uidKey, expiresIn);
            connection.setEx(refreshKey, expiresIn, accessToken.getBytes(StandardCharsets.UTF_8));
            connection.setEx(accessKey, expiresIn, Objects.requireNonNull(redisSerializer.serialize(userInfoInToken)));
            return null;
        });
        tokenInfoBO.setAccessToken(encryptToken(accessToken));
        tokenInfoBO.setRefreshToken(encryptToken(refreshToken));
        return tokenInfoBO;
    }

    public ServerResponseEntity<UserInfoInTokenBO> getUserInfoByAccessToken(String accessToken, boolean neeDecrypt) {
        if (StrUtil.isBlank(accessToken)) {
            return ServerResponseEntity.showFailMsg("accessToken is blank");
        }
        if (neeDecrypt) {

        }
        return null;
    }

    private ServerResponseEntity<String> decryptToken(String data) {
        String decryptToken;
        String decryptStr;

        try {
            decryptStr = Base64.decodeStr(data);
            decryptToken = decryptStr.substring(0, 32);
            long createTokenTime = Long.parseLong(decryptStr.substring(32, 45));
            long second = 1000L;
            if (System.currentTimeMillis() - createTokenTime > expiresIn * second) {
                return ServerResponseEntity.showFailMsg("token 格式有误");
            }
        } catch (NumberFormatException e) {
            logger.error(e.getMessage());
            return ServerResponseEntity.showFailMsg("token格式有误");
        }
        //防止解密后的token是脚本，从而对redis进行攻击，uuid只能是数字和小写字母
        if (!PrincipalUtil.isSimpleChar(decryptStr)) {
            return ServerResponseEntity.showFailMsg("token格式有误");
        }
        return ServerResponseEntity.success(decryptToken);
    }


    public TokenInfoVo storeAndGetVo(UserInfoInTokenBO userInfoInTokenBO){
        TokenInfoBO tokenInfoBO = storeAccessToken(userInfoInTokenBO);
        TokenInfoVo tokenInfoVo = new TokenInfoVo();
        tokenInfoVo.setAccessToken(tokenInfoBO.getAccessToken());
        tokenInfoVo.setRefreshToken(tokenInfoBO.getRefreshToken());
        tokenInfoVo.setExpiresIn(tokenInfoBO.getExpireIn());
        return tokenInfoVo;
    }


    private String encryptToken(String accessToken) {
        return Base64.encode(accessToken + System.currentTimeMillis());
    }

    private static String getApprovalKey(UserInfoInTokenBO userInfoInToken) {
        return StrUtil.COLON + userInfoInToken.getUid();
    }

    public String getUidToAccessKey(String approvalKey) {
        return CacheNames.UID_TO_ACCESS + approvalKey;
    }

    public String getAccessKey(String accessToken) {
        return CacheNames.ACCESS + accessToken;
    }

    public String getRefreshToAccessKey(String refreshToken) {
        return CacheNames.REFRESH_TO_ACCESS + refreshToken;
    }


}
