package com.x14nmall.cloud.product.config;

import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@EnableKnife4j
public class SwaggerConfiguration {

    @Bean
    public Docket baseRestApi() {
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select()
                .apis(RequestHandlerSelectors.basePackage("com.x14nmall.cloud.product.controller")).paths(PathSelectors.any())
                .build();
    }

    @Bean
    public ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("x14nmall").description("swagger").termsOfServiceUrl("")
                .contact(new Contact("x14nIT", "", "")).version("1.0").build();
    }

}

