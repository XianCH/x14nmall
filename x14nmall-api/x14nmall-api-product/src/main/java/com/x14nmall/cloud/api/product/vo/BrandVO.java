package com.x14nmall.cloud.api.product.vo;


import com.x14nmall.cloud.common.model.BaseModel;
import com.x14nmall.cloud.common.vo.BaseVO;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;
import java.util.Locale;

public class BrandVO extends BaseVO{
    private static final long serialVersionUID = 1L;

    @ApiModelProperty("brand_id")
    private Long brandId;

    @ApiModelProperty("品牌名称")
    private String brandName;

    @ApiModelProperty("图片路径")
    private String imgUrl;

    @ApiModelProperty("品牌描述")
    private String des;

    @ApiModelProperty("搜索首字母")
    private String firstLetter;


    @ApiModelProperty("品牌下面的分类")
    private List<CategoryVO> categories;

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

    public List<CategoryVO> getCategories() {
        return categories;
    }

    public void setCategories(List<CategoryVO> categories) {
        this.categories = categories;
    }

    @Override
    public String toString() {
        return "BrandVO{" +
                "brandId=" + brandId +
                ", brandName='" + brandName + '\'' +
                ", imgUrl='" + imgUrl + '\'' +
                ", des='" + des + '\'' +
                ", firstLetter='" + firstLetter + '\'' +
                ", categories=" + categories +
                '}';
    }
}
