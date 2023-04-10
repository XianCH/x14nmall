package com.x14nmall.cloud.user.service.impl;


import com.x14nmall.cloud.user.dto.UserRegisterDTO;
import com.x14nmall.cloud.user.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {



    @Override
    public Long saveRegisterInfo(UserRegisterDTO userRegisterInfo) {
        //检查用户是否已经注册过了

        return null;
    }
}
