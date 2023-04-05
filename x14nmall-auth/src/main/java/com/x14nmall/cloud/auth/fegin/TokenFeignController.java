package com.x14nmall.cloud.auth.fegin;

import com.x14nmall.cloud.api.auth.bo.UserInfoInTokenBO;
import com.x14nmall.cloud.api.auth.feign.TokenFeignClient;
import com.x14nmall.cloud.auth.manager.TokenStore;
import com.x14nmall.cloud.common.core.response.ServerResponseEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TokenFeignController implements TokenFeignClient {

    private static final Logger logger = LoggerFactory.getLogger(TokenFeignController.class);

    @Autowired
    private TokenStore tokenStore;

    @Override
    public ServerResponseEntity<UserInfoInTokenBO> checkToken(String accessToken) {
        return tokenStore.getUserInfoByAccessToken(accessToken,true);
    }
}
