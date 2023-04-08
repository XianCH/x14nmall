package com.x14nmall.cloud.product.model;

import com.x14nmall.cloud.common.core.model.BaseModel;


import java.io.Serializable;

public class SpuVintageTee extends BaseModel implements Serializable {

    private final static Long serialVersionUID =1L;

    private Long spuId;

    private String spuName;

    private Long themeId;

    private Long actorId;

    private Long categoryId;

    public SpuVintageTee(Long spuId, String spuName, Long themeId, Long actorId, Long categoryId) {
        this.spuId = spuId;
        this.spuName = spuName;
        this.themeId = themeId;
        this.actorId = actorId;
        this.categoryId = categoryId;
    }

    public Long getSpuId() {
        return spuId;
    }

    public void setSpuId(Long spuId) {
        this.spuId = spuId;
    }

    public String getSpuName() {
        return spuName;
    }

    public void setSpuName(String spuName) {
        this.spuName = spuName;
    }

    public Long getThemeId() {
        return themeId;
    }

    public void setThemeId(Long themeId) {
        this.themeId = themeId;
    }

    public Long getActorId() {
        return actorId;
    }

    public void setActorId(Long actorId) {
        this.actorId = actorId;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    @Override
    public String toString() {
        return "SpuVintageTee{" +
                "spuId=" + spuId +
                ", spuName='" + spuName + '\'' +
                ", themeId=" + themeId +
                ", actorId=" + actorId +
                ", categoryId=" + categoryId +
                '}';
    }
}
