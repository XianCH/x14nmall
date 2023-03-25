package com.x14nmall.cloud.common.database.vo;

import io.swagger.annotations.ApiModelProperty;

import java.util.List;

public class PageVO<T> {

    @ApiModelProperty("总页数")
    private Integer pages;

    @ApiModelProperty("总条目数")
    private Long total;

    @ApiModelProperty
    private List<T> list;


    public Integer getPages() {
        return pages;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "PageVO{" +
                "pages=" + pages +
                ", total=" + total +
                ", list=" + list +
                '}';
    }
}
