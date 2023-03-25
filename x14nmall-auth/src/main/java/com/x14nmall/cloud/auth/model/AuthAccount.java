package com.x14nmall.cloud.auth.model;

import com.x14nmall.cloud.common.database.annotations.DistributedId;
<<<<<<< HEAD
import com.x14nmall.cloud.common.core.model.BaseModel;
=======
import com.x14nmall.cloud.common.model.BaseModel;
>>>>>>> develop

public class AuthAccount extends BaseModel {

    @DistributedId("x14nmall-auth-account")
    private Long uid;

    private String username;

    private String password;

    private String createIP;

    private Integer status;

    private Long userId;


    /*private Integer sysType;*/
    /*private Long tenantId;*/
    /*private Integer isAdmin*/

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

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
