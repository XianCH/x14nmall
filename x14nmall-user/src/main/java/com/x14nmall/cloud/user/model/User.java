package com.x14nmall.cloud.user.model;

import com.x14nmall.cloud.common.core.model.BaseModel;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

import java.io.Serializable;

public class User extends BaseModel implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long userId;

    private String username;

    private String nickName;

    private String pic;

    private Integer status;


}
