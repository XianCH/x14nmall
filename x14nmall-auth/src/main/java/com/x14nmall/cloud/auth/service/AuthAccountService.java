package com.x14nmall.cloud.auth.service;

import com.x14nmall.cloud.api.auth.bo.UserInfoInTokenBO;
<<<<<<< HEAD
import com.x14nmall.cloud.common.core.response.ServerResponseEntity;
=======
import com.x14nmall.cloud.common.response.ServerResponseEntity;
>>>>>>> develop

public interface AuthAccountService {

    /**
     * 通过输入的用户名和密码，并校验部分用户信息
     */
    ServerResponseEntity<UserInfoInTokenBO> getUserInfoInTokenByInputUserNameAndPassword(String inputUserName,String password);


}
