package com.x14nmall.cloud.common.core.handler;


import cn.hutool.core.util.StrUtil;
import com.x14nmall.cloud.common.core.exception.X14nmallException;
import com.x14nmall.cloud.common.core.response.ResponseEnum;
import com.x14nmall.cloud.common.core.response.ServerResponseEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestController
@RestControllerAdvice
public class DefaultExceptionHandlerConfig {
    private static final Logger logger = LoggerFactory.getLogger(DefaultExceptionHandlerConfig.class);

    @ExceptionHandler(X14nmallException.class)
    public ResponseEntity<ServerResponseEntity<Object>> x14nmallExceptionHandler(X14nmallException e) {
        logger.error("x14nmallExceptionHandler", e);

        ResponseEnum responseEnum = e.getResponseEnum();
        if (responseEnum != null) {
            return ResponseEntity.status(HttpStatus.OK).body(ServerResponseEntity.fail(responseEnum, e.getObject()));
        }
        return ResponseEntity.status(HttpStatus.OK).body(ServerResponseEntity.showFailMsg(e.getMessage()));
    }

    /**
     *  传递参数异常处理
     * @param e
     * @return
     */

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ServerResponseEntity<List<String>>> handleMethodArgumentNotValidException(
            MethodArgumentNotValidException e) {
        logger.error("handleMethodArgumentNotValidException", e);
        List<String> errorMessages = new ArrayList<>();
        for (FieldError error : e.getBindingResult().getFieldErrors()) {
            errorMessages.add(error.getField() + ":" + error.getDefaultMessage());
        }
        return ResponseEntity.badRequest().body(ServerResponseEntity.fail(ResponseEnum.INVALID_REQUEST_PARAMETER, errorMessages));
    }

    /**
     * 参数丢失异常处理
     * @param e
     * @return
     */

    @ExceptionHandler(MissingServletRequestParameterException.class)
    public ResponseEntity<ServerResponseEntity<Object>> handleMissingServletRequestParameterException(
            MissingServletRequestParameterException e) {
        String errorMessage = String.format("Missing parameter '%s'", e.getParameterName());
        return ResponseEntity.badRequest().body(ServerResponseEntity.fail(ResponseEnum.INVALID_REQUEST_PARAMETER, errorMessage));
    }

}

