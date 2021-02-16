package com.myBatis.EmployeeCrud.swagger;

import com.google.common.base.Predicate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static com.google.common.base.Predicates.or;
import static springfox.documentation.builders.PathSelectors.regex;
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket postsApi(){
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("swagger-api")
                .apiInfo(apiInfo()).select().paths(postPaths()).build();
    }

    private Predicate<String> postPaths(){
        return or(regex("/api/v1/.*"),regex("/api/v1/.*"));
    }

    private ApiInfo apiInfo(){
        return  new ApiInfoBuilder().title("Test Rest Api Documentation 2")
                .description("this is a swagger demo")
                .contact("sachin@gmail.com")
                .license("Sachin license")
                .licenseUrl("jkfdks@jfd")
                .termsOfServiceUrl("sdjhs@jk.com")
                .version("1.0").build();
    }
}
