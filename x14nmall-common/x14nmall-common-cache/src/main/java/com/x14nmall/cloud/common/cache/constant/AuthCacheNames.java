package com.x14nmall.cloud.common.cache.constant;

public interface AuthCacheNames {

    String AUTH_PREFIX = "x14nmall_auth:";

    String AUTH_TOKEN_PREFIX = AUTH_PREFIX + "token:";

    String ACCESS = AUTH_TOKEN_PREFIX + "access:";

    String REFRESH_TO_ACCESS = AUTH_TOKEN_PREFIX + "refresh_to_access:";

    String UID_TO_ACCESS = AUTH_TOKEN_PREFIX + "uid_to_access:";


}
