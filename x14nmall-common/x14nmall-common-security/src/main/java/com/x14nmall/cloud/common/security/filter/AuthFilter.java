package com.x14nmall.cloud.common.security.filter;


import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.StrUtil;
import com.x14nmall.cloud.api.auth.bo.UserInfoInTokenBO;
import com.x14nmall.cloud.api.auth.feign.TokenFeignClient;
import com.x14nmall.cloud.common.core.constant.Auth;
import com.x14nmall.cloud.common.core.handler.HttpHandler;
import com.x14nmall.cloud.common.core.response.ResponseEnum;
import com.x14nmall.cloud.common.core.response.ServerResponseEntity;
import com.x14nmall.cloud.common.security.AuthUserContext;
import com.x14nmall.cloud.common.security.adapter.AuthConfigAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import org.springframework.util.AntPathMatcher;

import java.util.List;

@Component
public class AuthFilter implements Filter {

    @Autowired
    private AuthConfigAdapter authConfigAdapter;

    @Autowired
    private TokenFeignClient tokenFeignClient;

    @Autowired
    private HttpHandler httpHandler;

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse rep = (HttpServletResponse) servletResponse;

        List<String> excludePathPatterns = authConfigAdapter.excludePathPatterns();


        if (Auth.CHECK_TOKEN_URI.equals(req.getRequestURI())) {
            filterChain.doFilter(req, rep);
            return;
        }

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
        if (!userInfoInTokenBOServerResponseEntity.isSuccess()){
            httpHandler.printServerResponseToWeb(ServerResponseEntity.fail(ResponseEnum.UNAUTHORIZED));
            return;
        }
        UserInfoInTokenBO userInfoInTokenBO = userInfoInTokenBOServerResponseEntity.getData();
        try {
            AuthUserContext.set(userInfoInTokenBO);
            filterChain.doFilter(req,rep);
        } finally {
            AuthUserContext.clean();
        }


    }
}
