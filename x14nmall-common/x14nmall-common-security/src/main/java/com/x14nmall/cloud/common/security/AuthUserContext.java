package com.x14nmall.cloud.common.security;

import com.x14nmall.cloud.api.auth.bo.UserInfoInTokenBO;

public class AuthUserContext {
    private final static ThreadLocal<UserInfoInTokenBO> USER_INFO_IN_TOKEN_HOLDER = new ThreadLocal<>();

    public static UserInfoInTokenBO get(){
        return USER_INFO_IN_TOKEN_HOLDER.get();
    }

    public static void set(UserInfoInTokenBO userInfoInTokenBO){
        USER_INFO_IN_TOKEN_HOLDER.set(userInfoInTokenBO);
    }

    public static void clean(){
        if (USER_INFO_IN_TOKEN_HOLDER.get()!=null){
            USER_INFO_IN_TOKEN_HOLDER.remove();
        }
    }
}
