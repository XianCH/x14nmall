package com.x14nmall.cloud.common.core.exception;

import com.x14nmall.cloud.common.core.response.ResponseEnum;

public class X14nmallException extends RuntimeException{
    private static final long serialVersionUID = 1L;

    private Object object;

    private ResponseEnum responseEnum;

    public X14nmallException(String msg){
        super(msg);
    }

    public X14nmallException(String msg,Object object){
        super(msg);
        this.object = object;
    }

    public X14nmallException(String msg, Throwable cause){
        super(msg,cause);
    }

    public X14nmallException(ResponseEnum responseEnum){
        super(responseEnum.getMsg());
        this.responseEnum = responseEnum;
    }

    public X14nmallException(ResponseEnum responseEnum,Object object){
        super(responseEnum.getMsg());
        this.responseEnum = responseEnum;
        this.object = object;
    }

    public Object getObject() {
        return object;
    }

    public ResponseEnum getResponseEnum() {
        return responseEnum;
    }
}
