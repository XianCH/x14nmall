package com.x14nmall.cloud.auth.fegin;


import com.x14nmall.cloud.api.auth.feign.AccountFeignClient;
import com.x14nmall.cloud.api.auth.vo.AuthAccountVO;
import com.x14nmall.cloud.auth.mapper.AuthAccountMapper;
import com.x14nmall.cloud.common.core.response.ServerResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountFeignController implements AccountFeignClient {

    @Autowired
    AuthAccountMapper authAccountMapper;


    @Override
    public ServerResponseEntity<AuthAccountVO> getUserByUserName(String username) {
        return ServerResponseEntity.success(authAccountMapper.getUserByUserName(username));
    }
}
