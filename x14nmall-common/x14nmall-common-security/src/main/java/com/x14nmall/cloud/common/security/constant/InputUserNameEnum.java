package com.x14nmall.cloud.common.security.constant;

public enum InputUserNameEnum {

    USERNAME(1),

    PHONE(2),

    EMAIL(3),
    ;


    private final Integer value;

    public Integer value() {
        return value;
    }

    InputUserNameEnum(Integer value) {
        this.value = value;
    }
}
