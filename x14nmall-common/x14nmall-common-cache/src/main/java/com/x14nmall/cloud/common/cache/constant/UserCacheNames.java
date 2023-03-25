package com.x14nmall.cloud.common.cache.constant;

public interface UserCacheNames {

    /**
     * 前缀
     */
    String USER_PREFIX ="x14nmall_user";
    /**
     * 用户信息存储key
     */
    String USER_INFO = USER_PREFIX + "info:";

    /**
     * 用户默认地址存储key
     */
    String USER_DEFAULT_ADDR = USER_PREFIX + "user_addr:user_id:";


}
