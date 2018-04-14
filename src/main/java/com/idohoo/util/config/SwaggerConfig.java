package com.idohoo.util.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
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
@EnableWebMvc
@EnableSwagger2
@Configuration
@Order(99)
public class SwaggerConfig {

    private final SwaggerInfoConfig swaggerInfoConfig;

    @Autowired
    public SwaggerConfig(SwaggerInfoConfig swaggerInfoConfig) {
        this.swaggerInfoConfig = swaggerInfoConfig;
    }

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
