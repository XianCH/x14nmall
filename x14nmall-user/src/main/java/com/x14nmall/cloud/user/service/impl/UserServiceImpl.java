package com.x14nmall.cloud.user.service.impl;


import com.sun.org.apache.regexp.internal.RE;
import com.x14nmall.cloud.api.auth.feign.AccountFeignClient;
import com.x14nmall.cloud.api.auth.vo.AuthAccountVO;
import com.x14nmall.cloud.common.core.exception.X14nmallException;
import com.x14nmall.cloud.common.core.response.ServerResponseEntity;
import com.x14nmall.cloud.user.dto.UserRegisterDTO;
import com.x14nmall.cloud.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private AccountFeignClient accountFeignClient;



    @Override
    public Long saveRegisterInfo(UserRegisterDTO userRegisterInfo) {
        this.checkRegisterInfo(userRegisterInfo);
        //生成id

        //创建数据类型


        return null;
    }

    private void checkRegisterInfo(UserRegisterDTO userRegisterDTO) {
        ServerResponseEntity<AuthAccountVO> responseEntity = accountFeignClient.getUserByUserName(userRegisterDTO.getUserName());
        if (Objects.nonNull(responseEntity)){
            throw new X14nmallException("用户已存在");
        }else {
            throw  new X14nmallException(responseEntity.getMsg());
        }
    }
}
