package com.x14nmall.cloud.common.security.bo;

import com.x14nmall.cloud.api.auth.bo.UserInfoInTokenBO;

public class TokenInfoBO {

    /**
     * 保存在token信息里面的用户信息
     */
    private UserInfoInTokenBO userInfoInTokenBO;

    private String accessToken;

    private String refreshToken;

    /**
     * 多少秒后过期
     */
    private Integer expireIn;

    public UserInfoInTokenBO getUserInfoInTokenBO() {
        return userInfoInTokenBO;
    }

    public void setUserInfoInTokenBO(UserInfoInTokenBO userInfoInTokenBO) {
        this.userInfoInTokenBO = userInfoInTokenBO;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public Integer getExpireIn() {
        return expireIn;
    }

    public void setExpireIn(Integer expireIn) {
        this.expireIn = expireIn;
    }

    @Override
    public String toString() {
        return "TokenInfoBO{" +
                "userInfoInTokenBO=" + userInfoInTokenBO +
                ", accessToken='" + accessToken + '\'' +
                ", refreshToken='" + refreshToken + '\'' +
                ", expireIn=" + expireIn +
                '}';
    }
}
