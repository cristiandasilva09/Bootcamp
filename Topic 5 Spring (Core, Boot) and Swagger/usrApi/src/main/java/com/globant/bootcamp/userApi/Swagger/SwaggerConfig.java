/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.globant.bootcamp.userApi.Swagger;

import java.time.LocalDateTime;
import java.util.Date;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import static springfox.documentation.builders.PathSelectors.regex;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 *
 * @author Cristian
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
      @Bean
    public Docket newsApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("user")
                .apiInfo(apiInfo())
                .directModelSubstitute(LocalDateTime.class, Date.class)
                .select()
                .paths(regex("/user.*"))
                .build();
    }
 
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Users REST api")
                .description("PoC of a REST api, Users")
                .termsOfServiceUrl("http://en.wikipedia.org/wiki/Terms_of_service")
                .version("2.0")
                .build();
    }
}
