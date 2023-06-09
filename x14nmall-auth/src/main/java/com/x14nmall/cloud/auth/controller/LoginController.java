package com.x14nmall.cloud.auth.controller;


import com.x14nmall.cloud.api.auth.bo.UserInfoInTokenBO;
import com.x14nmall.cloud.api.auth.vo.TokenInfoVo;
import com.x14nmall.cloud.auth.dto.AuthenticationDTO;
import com.x14nmall.cloud.auth.manager.TokenStore;
import com.x14nmall.cloud.auth.service.AuthAccountService;
import com.x14nmall.cloud.common.core.response.ServerResponseEntity;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid;

@RestController
@Api(tags = "登录")
public class LoginController {

    @Autowired
    AuthAccountService authAccountService;

    @Autowired
    TokenStore tokenStore;

    @PostMapping("/ua/login")
    @ApiOperation(value = "用户端账号登录",notes = "通过账号登录，还要携带用户的类型，也就是用户所在的系统")
    public ServerResponseEntity<TokenInfoVo> login(
            @Valid @RequestBody AuthenticationDTO authenticationDTO) {
        ServerResponseEntity<UserInfoInTokenBO> userInfoInTokenResponse = authAccountService
                .getUserInfoInTokenByInputUserNameAndPassword(authenticationDTO.getPrincipal(),
                        authenticationDTO.getCredentials());
        if (!userInfoInTokenResponse.isSuccess()){
            return ServerResponseEntity.transform(userInfoInTokenResponse);
        }
        UserInfoInTokenBO data = userInfoInTokenResponse.getData();
        return ServerResponseEntity.success(tokenStore.storeAndGetVo(data));
    }


}
