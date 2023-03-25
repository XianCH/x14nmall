package com.x14nmall.cloud.product.model;

import com.x14nmall.cloud.common.core.model.BaseModel;

import java.io.Serializable;

public class SpuPants extends BaseModel implements Serializable {

    private final static Long serialVersionUID = 1L;

    private Long spuId;

    private String spuName;

    private Long brandId;

    private Long categoryId;

    private String model;

    public SpuPants(Long spuId, String spuName, Long brandId, Long categoryId, String model) {
        this.spuId = spuId;
        this.spuName = spuName;
        this.brandId = brandId;
        this.categoryId = categoryId;
        this.model = model;
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

    public Long getBrandId() {
        return brandId;
    }

    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public String toString() {
        return "spu_pants{" +
                "spuId=" + spuId +
                ", spuName='" + spuName + '\'' +
                ", brandId=" + brandId +
                ", categoryId=" + categoryId +
                ", model='" + model + '\'' +
                '}';
    }
}
