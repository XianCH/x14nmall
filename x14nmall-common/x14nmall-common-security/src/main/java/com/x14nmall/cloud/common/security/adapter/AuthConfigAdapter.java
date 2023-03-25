package com.x14nmall.cloud.common.security.adapter;

import java.util.List;

public interface AuthConfigAdapter {

    List<String> pathPatterns();

    List<String> excludePathPatterns(String... paths);
}
