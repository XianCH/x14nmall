package com.x14nmall.cloud.common.cache.adapter;

import com.x14nmall.cloud.common.cache.bo.CacheNameWithTtlBO;

import java.util.List;

public interface CacheTtlAdapter
{
    List<CacheNameWithTtlBO> listCacheNameWithTtl();
}
