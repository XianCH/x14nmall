package com.x14nmall.cloud.product.model;


import com.x14nmall.cloud.common.core.model.BaseModel;


import java.io.Serializable;
import java.math.BigDecimal;

public class SkuVintageTee extends BaseModel implements Serializable {

    private final static Long serialVersionUID = 1L;

    private Long skuId;

    private Long spuId;

    private String imgUrl;

    private String imgUrls;

    private BigDecimal priceFee;

    private BigDecimal priceMarketFee;

    private Integer status;

    private Integer ifInSales;

    private BigDecimal clothLength;

    private BigDecimal clothCir;

    private String years;

    public SkuVintageTee(Long skuId, Long spuId, String imgUrl, String imgUrls, BigDecimal priceFee, BigDecimal priceMarketFee, Integer status, Integer ifInSales, BigDecimal clothLength, BigDecimal clothCir, String years) {
        this.skuId = skuId;
        this.spuId = spuId;
        this.imgUrl = imgUrl;
        this.imgUrls = imgUrls;
        this.priceFee = priceFee;
        this.priceMarketFee = priceMarketFee;
        this.status = status;
        this.ifInSales = ifInSales;
        this.clothLength = clothLength;
        this.clothCir = clothCir;
        this.years = years;
    }

    public Long getSkuId() {
        return skuId;
    }

    public void setSkuId(Long skuId) {
        this.skuId = skuId;
    }

    public Long getSpuId() {
        return spuId;
    }

    public void setSpuId(Long spuId) {
        this.spuId = spuId;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getImgUrls() {
        return imgUrls;
    }

    public void setImgUrls(String imgUrls) {
        this.imgUrls = imgUrls;
    }

    public BigDecimal getPriceFee() {
        return priceFee;
    }

    public void setPriceFee(BigDecimal priceFee) {
        this.priceFee = priceFee;
    }

    public BigDecimal getPriceMarketFee() {
        return priceMarketFee;
    }

    public void setPriceMarketFee(BigDecimal priceMarketFee) {
        this.priceMarketFee = priceMarketFee;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getIfInSales() {
        return ifInSales;
    }

    public void setIfInSales(Integer ifInSales) {
        this.ifInSales = ifInSales;
    }

    public BigDecimal getClothLength() {
        return clothLength;
    }

    public void setClothLength(BigDecimal clothLength) {
        this.clothLength = clothLength;
    }

    public BigDecimal getClothCir() {
        return clothCir;
    }

    public void setClothCir(BigDecimal clothCir) {
        this.clothCir = clothCir;
    }

    public String getYears() {
        return years;
    }

    public void setYears(String years) {
        this.years = years;
    }

    @Override
    public String toString() {
        return "SkuVintageTee{" +
                "skuId=" + skuId +
                ", spuId=" + spuId +
                ", imgUrl='" + imgUrl + '\'' +
                ", imgUrls='" + imgUrls + '\'' +
                ", priceFee=" + priceFee +
                ", priceMarketFee=" + priceMarketFee +
                ", status=" + status +
                ", ifInSales=" + ifInSales +
                ", clothLength=" + clothLength +
                ", clothCir=" + clothCir +
                ", years='" + years + '\'' +
                '}';
    }
}
