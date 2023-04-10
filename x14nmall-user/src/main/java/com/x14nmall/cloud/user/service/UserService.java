package com.x14nmall.cloud.user.service;

import com.x14nmall.cloud.user.dto.UserRegisterDTO;

public interface UserService {

    Long saveRegisterInfo(UserRegisterDTO userRegisterInfo);
}
