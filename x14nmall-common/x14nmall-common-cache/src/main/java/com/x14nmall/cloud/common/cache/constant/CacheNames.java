package com.x14nmall.cloud.common.cache.constant;

public interface CacheNames extends UserCacheNames, AuthCacheNames {

    /**
     * cacheNames 与 key之间的默认连接字符
     */
    String UNION = "::";

    /**
     * key内部的连接字符
     */
    String UNION_KEY = ":";
}
