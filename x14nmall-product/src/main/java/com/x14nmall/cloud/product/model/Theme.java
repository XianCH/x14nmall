package com.x14nmall.cloud.product.model;

import com.x14nmall.cloud.common.model.BaseModel;

import java.io.Serializable;

public class Theme extends BaseModel implements Serializable {

    private final static Long serialVersionUID = 1L;

    private Long themeId;

    private String themeName;

    private String imgUrl;

    private String firstLetter;

    public Theme(Long themeId, String themeName, String imgUrl, String firstLetter) {
        this.themeId = themeId;
        this.themeName = themeName;
        this.imgUrl = imgUrl;
        this.firstLetter = firstLetter;
    }

    public Long getThemeId() {
        return themeId;
    }

    public void setThemeId(Long themeId) {
        this.themeId = themeId;
    }

    public String getThemeName() {
        return themeName;
    }

    public void setThemeName(String themeName) {
        this.themeName = themeName;
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
        return "Theme{" +
                "themeId=" + themeId +
                ", themeName='" + themeName + '\'' +
                ", imgUrl='" + imgUrl + '\'' +
                ", firstLetter='" + firstLetter + '\'' +
                '}';
    }
}
