package com.idohoo.util.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * swagger 配置
 * created by yinian on 18-4-12.
 */
@EnableSwagger2
@Order(99)
public class SwaggerConfig {

    @Autowired
    private  SwaggerInfoConfig swaggerInfoConfig;

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage(swaggerInfoConfig.getBasePackage())) // 注意修改此处的包名
                .paths(PathSelectors.any())
                .build();
    }

    /**
     * 配置相关的文档信息
     * @return 文档信息
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title(swaggerInfoConfig.getTitle())
                .description(swaggerInfoConfig.getDescription())
                .termsOfServiceUrl(swaggerInfoConfig.getServiceUrl())
                .version(swaggerInfoConfig.getVersion())
                .build();
    }

}
