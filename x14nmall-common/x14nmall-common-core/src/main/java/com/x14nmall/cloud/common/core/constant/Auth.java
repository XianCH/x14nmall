package com.x14nmall.cloud.common.core.constant;

import com.x14nmall.cloud.common.core.feign.FeignInsideAuthConfig;

import static com.x14nmall.cloud.common.core.feign.FeignInsideAuthConfig.FEIGN_INSIDE_URL_PREFIX;

public interface Auth {

    String CHECK_TOKEN_URI = FEIGN_INSIDE_URL_PREFIX + "/token/checkToken";

}
