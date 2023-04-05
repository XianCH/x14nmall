package com.x14nmall.cloud.product.model;

<<<<<<< HEAD
import com.x14nmall.cloud.common.core.model.BaseModel;
=======
import com.x14nmall.cloud.common.model.BaseModel;
>>>>>>> develop

import java.io.Serializable;

public class Brand extends BaseModel implements Serializable {

    private final static Long serialVersionUID = 1L;

    private Long brandId;

    private String brandName;

    private String imgUrl;

    private String des;

    private String firstLetter;

    public Brand(Long brandId, String brandName, String imgUrl, String des, String firstLetter) {
        this.brandId = brandId;
        this.brandName = brandName;
        this.imgUrl = imgUrl;
        this.des = des;
        this.firstLetter = firstLetter;
    }

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

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public String getFirstLetter() {
        return firstLetter;
    }

    public void setFirstLetter(String firstLetter) {
        this.firstLetter = firstLetter;
    }

    @Override
    public String toString() {
        return "Brand{" +
                "brandId=" + brandId +
                ", brandName='" + brandName + '\'' +
                ", imgUrl='" + imgUrl + '\'' +
                ", des='" + des + '\'' +
                ", firstLetter='" + firstLetter + '\'' +
                '}';
    }
}
