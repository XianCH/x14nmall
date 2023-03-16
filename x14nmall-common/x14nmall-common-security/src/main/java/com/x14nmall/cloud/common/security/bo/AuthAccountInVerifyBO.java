package com.x14nmall.cloud.common.security.bo;

import com.x14nmall.cloud.api.auth.bo.UserInfoInTokenBO;

public class AuthAccountInVerifyBO extends UserInfoInTokenBO {
    private String password;
    private Integer status;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "AuthAccountInVerifyBO{" +
                "password='" + password + '\'' +
                ", status=" + status +
                '}';
    }
}
