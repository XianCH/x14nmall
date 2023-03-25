package com.x14nmall.cloud.common.core.handler;


import cn.hutool.core.util.CharsetUtil;
import com.x14nmall.cloud.common.core.response.ServerResponseEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletResponse;

@Component
public class HttpHandler {

    private static final Logger logger = LoggerFactory.getLogger(HttpHandler.class);


    public <T> void  printServerResponseToWeb(ServerResponseEntity<T> serverResponseEntity){
        if (serverResponseEntity == null){
            logger.info("print obj is null");
            return;
        }

        ServletRequestAttributes requestAttributes =(ServletRequestAttributes) RequestContextHolder
                .getRequestAttributes();
        if (requestAttributes == null){
            logger.error("requestAttributes is null,can not print to web");
            return;
        }
        HttpServletResponse response = requestAttributes.getResponse();
        if (response == null){
            logger.error("httpServletResponse is null, can not print to web");
            return;
        }
        logger.error("response error" + serverResponseEntity.getMsg());
        response.setCharacterEncoding(CharsetUtil.UTF_8);
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
    }
}
