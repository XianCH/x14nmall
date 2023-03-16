package com.x14nmall.cloud.auth;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication(scanBasePackages = {"com.x14nmall.cloud"})
@EnableFeignClients(basePackages = "com.x14nmall.cloud.api.**.feign")
public class AuthApplication {

    public static void main(String[] args) {
        SpringApplication.run(AuthApplication.class,args);
    }
}
