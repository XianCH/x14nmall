package com.x14nmall.cloud.biz.config;


import io.minio.MinioClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;

@RefreshScope
@Configuration
public class OssConfig {


    @Value("${biz.oss.endpoint}")
    private String endpoint;

    @Value("${biz.oss.bucket}")
    private String bucket;

    @Value("${biz.oss.access-key-secret}")
    private String key;

    @Value("${biz.oss.access-key-secret}")
    private String secret;

    @Value("${biz.oss.type}")
    private Integer ossType;

    @Value("${biz.oss.maxLength}")
    private Integer maxLength;

    public String getEndpoint() {
        return endpoint;
    }

    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }

    public String getBucket() {
        return bucket;
    }

    public void setBucket(String bucket) {
        this.bucket = bucket;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public Integer getOssType() {
        return ossType;
    }

    public void setOssType(Integer ossType) {
        this.ossType = ossType;
    }

    public Integer getMaxLength() {
        return maxLength;
    }

    public void setMaxLength(Integer maxLength) {
        this.maxLength = maxLength;
    }


}
