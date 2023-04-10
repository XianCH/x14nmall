package com.x14nmall.cloud.auth.service.impl;

import cn.hutool.core.util.StrUtil;
import com.sun.org.apache.regexp.internal.RE;
import com.x14nmall.cloud.api.auth.bo.UserInfoInTokenBO;
import com.x14nmall.cloud.auth.mapper.AuthAccountMapper;
import com.x14nmall.cloud.auth.service.AuthAccountService;

import com.x14nmall.cloud.common.core.response.ServerResponseEntity;
import com.x14nmall.cloud.common.security.bo.AuthAccountInVerifyBO;
import com.x14nmall.cloud.common.security.constant.InputUserNameEnum;
import com.x14nmall.cloud.common.core.util.PrincipalUtil;

import ma.glasnost.orika.MapperFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Objects;


@Service
public class AuthAccountServiceImpl implements AuthAccountService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthAccountMapper authAccountMapper;

    public static final String USER_NOT_FOUND_SECRET= "USER_NOT_FOUND_SECRET";

    private static String userNotFondEncodedPassword;

    @Autowired
    private MapperFacade mapperFacade;

    @Override
    public ServerResponseEntity<UserInfoInTokenBO> getUserInfoInTokenByInputUserNameAndPassword(String inputUserName, String password) {
        //对用户输入进行校验
        if (StrUtil.isBlank(inputUserName)){
            return ServerResponseEntity.showFailMsg("用户名不能为空");
        }
        if (StrUtil.isBlank(password)){
            return ServerResponseEntity.showFailMsg("密码不能为空");
        }

        //检验输入格式是否正确
        InputUserNameEnum inputUserNameEnum = null;
        if (PrincipalUtil.isUserName(inputUserName)){
            inputUserNameEnum = InputUserNameEnum.USERNAME;
        }
        if (inputUserNameEnum == null){
            return ServerResponseEntity.showFailMsg("请输入正确的用户名");
        }

        //查询返回用户密码信息
        AuthAccountInVerifyBO authAccountInVerifyBO = authAccountMapper.getAuthAccountInVerifyByInputUserName(inputUserNameEnum.value(), inputUserName);

        if (authAccountInVerifyBO == null){
            prepareTimingAttackProtection();
            mitigateAgainstTimeAttack(password);
            return ServerResponseEntity.showFailMsg("用户名或密码不正确");
        }


        if (authAccountInVerifyBO.getStatus()== 0 ){
            return ServerResponseEntity.showFailMsg("用户已被禁用，联系管理员");
        }

        //
        if (!passwordEncoder.matches(password,authAccountInVerifyBO.getPassword())){
            return ServerResponseEntity.showFailMsg("用户名或密码不正确");
        }
        return ServerResponseEntity.success(mapperFacade.map(authAccountInVerifyBO,UserInfoInTokenBO.class));
    }

    /**
     * 防止计时攻击
     */
    private void prepareTimingAttackProtection(){
        if (userNotFondEncodedPassword==null){
            userNotFondEncodedPassword = this.passwordEncoder.encode(USER_NOT_FOUND_SECRET);
        }
    }

    /**
     * 防止计时攻击
     */

    private void mitigateAgainstTimeAttack(String presentedPassword) {
        if (presentedPassword !=null){
            this.passwordEncoder.matches(presentedPassword,userNotFondEncodedPassword);
        }
    }

}
