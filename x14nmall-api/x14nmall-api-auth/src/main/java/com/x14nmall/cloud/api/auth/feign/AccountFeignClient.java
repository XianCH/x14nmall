package com.x14nmall.cloud.api.auth.feign;


import com.x14nmall.cloud.api.auth.vo.AuthAccountVO;
import com.x14nmall.cloud.common.core.feign.FeignInsideAuthConfig;
import com.x14nmall.cloud.common.core.response.ServerResponseEntity;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "x14nmall-auth", contextId = "account")
public interface AccountFeignClient {

    @PostMapping(value = FeignInsideAuthConfig.FEIGN_INSIDE_URL_PREFIX + "/insider/getUserInfoByUserName")
    ServerResponseEntity<AuthAccountVO> getUserByUserName(@RequestParam("username") String username);
}
