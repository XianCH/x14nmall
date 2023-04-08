package com.x14nmall.cloud.product.model;


import com.x14nmall.cloud.common.core.model.BaseModel;

import java.io.Serializable;

public class Category extends BaseModel implements Serializable {

    private final static Long serialVersionUID = 1L;

    private Long categoryId;

    private String categoryName;

    private String imgUrl;

    private String firstLetter;

    private String des;


    public Category(Long categoryId, String categoryName, String imgUrl, String firstLetter, String des) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.imgUrl = imgUrl;
        this.firstLetter = firstLetter;
        this.des = des;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
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

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    @Override
    public String toString() {
        return "Category{" +
                "categoryId=" + categoryId +
                ", categoryName='" + categoryName + '\'' +
                ", imgUrl='" + imgUrl + '\'' +
                ", firstLetter='" + firstLetter + '\'' +
                ", des='" + des + '\'' +
                '}';
    }
}
