package com.x14nmall.cloud.common.database.config;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan({"com.x14nmall.cloud.**.mapper"})
public class MybatisConfig {
}
