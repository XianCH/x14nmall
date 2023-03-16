package com.x14nmall.cloud.api.auth.bo;

public class UserInfoInTokenBO {

    /**
     * 用户在自己系统的用户id
     */
    private Long userId;

    /**
     * 全局唯一id
     */
    private Long uid;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    @Override
    public String toString() {
        return "UserInfoInTokenBO{" +
                "userId=" + userId +
                ", uid=" + uid +
                '}';
    }
}
