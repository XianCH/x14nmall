package com.x14nmall.cloud.common.security.filter;


import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.StrUtil;
import com.x14nmall.cloud.api.auth.bo.UserInfoInTokenBO;
import com.x14nmall.cloud.api.auth.feign.TokenFeignClient;
import com.x14nmall.cloud.common.core.constant.Auth;
import com.x14nmall.cloud.common.core.feign.FeignInsideAuthConfig;
import com.x14nmall.cloud.common.core.handler.HttpHandler;
import com.x14nmall.cloud.common.core.response.ResponseEnum;
import com.x14nmall.cloud.common.core.response.ServerResponseEntity;
import com.x14nmall.cloud.common.core.util.IpHelper;
import com.x14nmall.cloud.common.security.AuthUserContext;
import com.x14nmall.cloud.common.security.adapter.AuthConfigAdapter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import org.springframework.util.AntPathMatcher;

import java.util.List;
import java.util.Objects;

@Component
public class AuthFilter implements Filter {

    private static Logger log = LoggerFactory.getLogger(AuthFilter.class);

    @Autowired
    private AuthConfigAdapter authConfigAdapter;

    @Autowired
    private TokenFeignClient tokenFeignClient;

    @Autowired
    private HttpHandler httpHandler;

    @Autowired
    private FeignInsideAuthConfig feignInsideAuthConfig;

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse rep = (HttpServletResponse) servletResponse;

        //判断是否是内部调用接口
        if (!feignRequestCheck(req)){
            httpHandler.printServerResponseToWeb(ServerResponseEntity.fail(ResponseEnum.UNAUTHORIZED));
        }


        if (Auth.CHECK_TOKEN_URI.equals(req.getRequestURI())) {
            filterChain.doFilter(req, rep);
            return;
        }

        List<String> excludePathPatterns = authConfigAdapter.excludePathPatterns();

        if (CollectionUtil.isNotEmpty(excludePathPatterns)) {
            for (String excludePathPattern : excludePathPatterns) {
                AntPathMatcher antPathMatcher = new AntPathMatcher();
                if (antPathMatcher.match(excludePathPattern, req.getRequestURI())) {
                    filterChain.doFilter(req, rep);
                }
            }
        }

        String accessToken = req.getHeader("Authorization");

        if (StrUtil.isBlank(accessToken)) {
            httpHandler.printServerResponseToWeb(ServerResponseEntity.fail(ResponseEnum.UNAUTHORIZED));
            return;
        }
        ServerResponseEntity<UserInfoInTokenBO> userInfoInTokenBOServerResponseEntity =
                tokenFeignClient.checkToken(accessToken);
        if (!userInfoInTokenBOServerResponseEntity.isSuccess()) {
            httpHandler.printServerResponseToWeb(ServerResponseEntity.fail(ResponseEnum.UNAUTHORIZED));
            return;
        }
        UserInfoInTokenBO userInfoInTokenBO = userInfoInTokenBOServerResponseEntity.getData();
        try {
            AuthUserContext.set(userInfoInTokenBO);
            filterChain.doFilter(req, rep);
        } finally {
            AuthUserContext.clean();
        }

    }

    private boolean feignRequestCheck(HttpServletRequest request) {
        if (!request.getRequestURI().startsWith(FeignInsideAuthConfig.FEIGN_INSIDE_URL_PREFIX)) {
            return true;
        }
        String feignInsideSecret = request.getHeader(feignInsideAuthConfig.getKey());

        if (StrUtil.isBlank(feignInsideSecret) || !Objects.equals(feignInsideSecret, feignInsideAuthConfig.getSecret())) {
            return false;
        }
        List<String> ips = feignInsideAuthConfig.getIps();
        ips.removeIf(StrUtil::isBlank);
        if (CollectionUtil.isNotEmpty(ips) && !ips.contains(IpHelper.getIpAddr())) {
            log.error("ip not in ip White list: {}, ip, {}", ips, IpHelper.getIpAddr());
            return false;
        }
        return true;
    }
}
