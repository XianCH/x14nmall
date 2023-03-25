package com.x14nmall.cloud.api.product.vo;

<<<<<<< HEAD
import com.x14nmall.cloud.common.core.vo.BaseVO;
import io.swagger.annotations.ApiModelProperty;

=======
import com.x14nmall.cloud.common.vo.BaseVO;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

>>>>>>> develop
public class CategoryVO extends BaseVO {

    private static final long serialVersionUID = 1L;


    @ApiModelProperty("分类id")
    private Long categoryId;

    @ApiModelProperty("分类名称")
    private String categoryName;

    @ApiModelProperty("分类图片")
    private String imgUrl;

    @ApiModelProperty("搜索首字母")
    private String firstLetter;

    @ApiModelProperty("描述")
    private String des;

//    @ApiModelProperty("上级分类名称")
//    private List<String> pathNames;
//
//    @ApiModelProperty("子分类列表")
//    private List<CategoryVO> categories;


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
        return "CategoryVO{" +
                "categoryId=" + categoryId +
                ", categoryName='" + categoryName + '\'' +
                ", imgUrl='" + imgUrl + '\'' +
                ", firstLetter='" + firstLetter + '\'' +
                ", des='" + des + '\'' +
                '}';
    }
}
