package com.x14nmall.cloud.common.core.vo;

import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

public class BaseVO {

    @ApiModelProperty("创建时间")
    protected Date createTime;

    @ApiModelProperty("更新时间")
    protected Date updateTime;

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "BaseVO{" +
                "createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
