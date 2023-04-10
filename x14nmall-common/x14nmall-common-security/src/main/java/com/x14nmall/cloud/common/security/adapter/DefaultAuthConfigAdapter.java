package com.x14nmall.cloud.common.security.adapter;

import com.x14nmall.cloud.common.core.feign.FeignInsideAuthConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Component
public class DefaultAuthConfigAdapter implements AuthConfigAdapter{
    private static final Logger logger = LoggerFactory.getLogger(DefaultAuthConfigAdapter.class);

    private static final String DOC_URI = "/v2/api-docs";

    private static final String FEIGN_INSIDER_URI = FeignInsideAuthConfig.FEIGN_INSIDE_URL_PREFIX+"/insider/**";

    private static final String EXTERNAL_URI = "/**/ua/**";

    @Override
    public List<String> pathPatterns() {
        return Collections.singletonList("/*");
    }

    @Override
    public List<String> excludePathPatterns(String... paths) {
        ArrayList<String> arr = new ArrayList<>();
        arr.add(DOC_URI);
        arr.add(FEIGN_INSIDER_URI);
        arr.add(EXTERNAL_URI);
        arr.addAll(Arrays.asList(paths));
        return arr;
    }
}
