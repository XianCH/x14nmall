package com.x14nmall.cloud.auth.dto;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;

public class AuthenticationDTO {

    @NotBlank(message = "principal不能为空")
    @ApiModelProperty(value = "用户名",required = true)
    protected String principal;

    @NotBlank(message = "credentials不能为空")
    @ApiModelProperty(value = "密码",required = true)
    protected String credentials;

    /*系统类型*/

    public String getPrincipal() {
        return principal;
    }

    public void setPrincipal(String principal) {
        this.principal = principal;
    }

    public String getCredentials() {
        return credentials;
    }

    public void setCredentials(String credentials) {
        this.credentials = credentials;
    }

    @Override
    public String toString() {
        return "AuthenticationDTO{" +
                "principal='" + principal + '\'' +
                ", credentials='" + credentials + '\'' +
                '}';
    }

}
