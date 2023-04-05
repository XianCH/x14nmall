package com.x14nmall.cloud.common.core.response;

public enum ResponseEnum {
    OK("00000","OK"),
    SHOW_FAIL("A00001","FAIL"),
    METHOD_ARGUMENT_NOT_VALID("A00002","METHOD_ARGUMENT_NOT_VALID"),
    UNAUTHORIZED("A00004","UNAUTHORIZED")
    ;


    private final String code;
    private final String msg;

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    ResponseEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
