package com.x14nmall.cloud.product.model;

import com.x14nmall.cloud.common.core.model.BaseModel;

import java.io.Serializable;

public class Actor extends BaseModel implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long actorId;

    private String actorName;

    private String imgUrl;

    private String first_letter;

    public Actor(Long actorId, String actorName, String img_url, String first_letter) {
        this.actorId = actorId;
        this.actorName = actorName;
        this.imgUrl = img_url;
        this.first_letter = first_letter;
    }

    public Long getActorId() {
        return actorId;
    }

    public void setActorId(Long actorId) {
        this.actorId = actorId;
    }

    public String getActorName() {
        return actorName;
    }

    public void setActorName(String actorName) {
        this.actorName = actorName;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getFirst_letter() {
        return first_letter;
    }

    public void setFirst_letter(String first_letter) {
        this.first_letter = first_letter;
    }

    @Override
    public String toString() {
        return "Actor{" +
                "actorId=" + actorId +
                ", actorName='" + actorName + '\'' +
                ", imgUrl='" + imgUrl + '\'' +
                ", first_letter='" + first_letter + '\'' +
                '}';
    }
}
