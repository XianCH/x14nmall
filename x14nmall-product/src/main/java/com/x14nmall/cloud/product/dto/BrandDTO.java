package com.x14nmall.cloud.product.dto;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

public class BrandDTO {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("brand_id")
    private Long brandId;

    @NotNull(message = "品牌名称不能为空")
    @ApiModelProperty("品牌名称")
    private String brandName;

    @NotNull(message = "图片不能为空")
    @ApiModelProperty("品牌图片")
    private String imgUrl;

    @NotNull(message = "搜索首字母不能为空")
    @ApiModelProperty("搜索首字母")
    private String firstLetter;


    public Long getBrandId() {
        return brandId;
    }

    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getFirstLetter() {
        return firstLetter;
    }

    public void setFirstLetter(String firstLetter) {
        this.firstLetter = firstLetter;
    }

    @Override
    public String toString() {
        return "BrandDTO{" +
                "brandId=" + brandId +
                ", brandName='" + brandName + '\'' +
                ", imgUrl='" + imgUrl + '\'' +
                ", firstLetter='" + firstLetter + '\'' +
                '}';
    }
}
