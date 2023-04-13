package com.x14nmall.cloud.auth.mapper;

import com.x14nmall.cloud.api.auth.vo.AuthAccountVO;
import com.x14nmall.cloud.common.security.bo.AuthAccountInVerifyBO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


public interface AuthAccountMapper {
    AuthAccountInVerifyBO getAuthAccountInVerifyByInputUserName(@Param("inputUserNameType") Integer inputUserNameType,@Param("inputUserName")String inputUserName);

    AuthAccountVO getUserByUserName(String username);
}
