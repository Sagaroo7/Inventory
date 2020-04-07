package com.example.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import springfox.bean.validators.configuration.BeanValidatorPluginsConfiguration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@Import(BeanValidatorPluginsConfiguration.class)
public class SwaggerConfiguration {

    ApiInfo apiInfo()
    {
        return new ApiInfoBuilder()
                .title("Inventory Management Microservices")
                .description("This service provides CRUD operations for Inventory Management.")
                .license("Sagar Dave")
                .termsOfServiceUrl("www.spring.io.com")
                .version("Mark 2")
                .contact(new Contact("Sagar Dave", "http://www.4algos.com", "sagardave1992@gmail.com"))
                .build();
    }

    @Bean
    public Docket customImplementation()
    {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("Inventory Management Microservices")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.example"))
                .build()
                .apiInfo(apiInfo());
    }
}
