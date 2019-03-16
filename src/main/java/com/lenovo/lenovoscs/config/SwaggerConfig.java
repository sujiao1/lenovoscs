package com.lenovo.lenovoscs.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.ApiSelectorBuilder;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
//    @Value("${spring.profiles.active}")
//    private String env;


    @Bean
    public Docket createRestApi() {
        ApiSelectorBuilder apis = new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.lenovo.lenovoscs.controller"));
//        if("prod".equals(env)){
//            //生产环境不输出apis
//            return apis.paths(PathSelectors.none()).build();
//        }
        return apis.paths(PathSelectors.any()).build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title(" 核心  apis")
                .version("1.0")
                .build();
    }
}
