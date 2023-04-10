package com.x14nmall.cloud.user.controller;


import com.x14nmall.cloud.api.auth.vo.TokenInfoVo;
import com.x14nmall.cloud.common.core.response.ServerResponseEntity;
import com.x14nmall.cloud.user.dto.UserRegisterDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/ua/user/register")
public class UserRegisterController {


    @PostMapping
    public ServerResponseEntity<TokenInfoVo> register(@Valid @RequestBody UserRegisterDTO userRegisterDTO){
        return null;
    }
}
