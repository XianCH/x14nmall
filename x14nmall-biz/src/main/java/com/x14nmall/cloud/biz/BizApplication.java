package com.x14nmall.cloud.biz;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication(scanBasePackages = {"com.x14nmall.cloud"})
public class BizApplication {
    public static void main(String[] args) {
        SpringApplication.run(BizApplication.class,args);
    }
}
