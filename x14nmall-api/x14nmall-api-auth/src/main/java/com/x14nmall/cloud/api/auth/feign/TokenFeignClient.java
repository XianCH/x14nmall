package com.x14nmall.cloud.api.auth.feign;


import com.x14nmall.cloud.api.auth.bo.UserInfoInTokenBO;
import com.x14nmall.cloud.common.core.constant.Auth;
import com.x14nmall.cloud.common.core.response.ServerResponseEntity;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "x14nmall-auth",contextId = "token")
public interface TokenFeignClient {

    @GetMapping(value = Auth.CHECK_TOKEN_URI)
    ServerResponseEntity<UserInfoInTokenBO> checkToken(@RequestParam("accessToken") String accessToken);

}
