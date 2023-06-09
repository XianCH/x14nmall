package com.x14nmall.cloud.auth.model;

import com.x14nmall.cloud.common.database.annotations.DistributedId;

import com.x14nmall.cloud.common.core.model.BaseModel;



public class AuthAccount extends BaseModel {


    private Long userId;

    private String username;

    private String password;

    private String createIP;

    private Integer status;



    /*private Integer sysType;*/
    /*private Long tenantId;*/
    /*private Integer isAdmin*/

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCreateIP() {
        return createIP;
    }

    public void setCreateIP(String createIP) {
        this.createIP = createIP;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }



}
