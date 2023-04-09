package com.x14nmall.cloud.product;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;


@EnableFeignClients(basePackages = {"com.x14nmall.cloud.api.**.feign"})
@SpringBootApplication(scanBasePackages = "com.x14nmall.cloud")
public class ProductApplication {
    public static void main(String[] args) {
        SpringApplication.run(ProductApplication.class,args);
    }
}
