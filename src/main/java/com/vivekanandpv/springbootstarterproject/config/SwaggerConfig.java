package com.vivekanandpv.springbootstarterproject.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.List;

@Configuration
public class SwaggerConfig {
    @Bean
    public Docket getDocketForSwagger() {
        Docket docket = new Docket(DocumentationType.SWAGGER_2);

        return docket.select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build()
                .apiInfo(
                  new ApiInfo(
                          "Documentation Title",
                          "Documentation Description",
                          "v1.0.0",
                          "http://terms.service.url",
                          new Contact("John Doe", "http://john.company.com", "john@gmail.com"),
                          "Licence Type",
                          "http://licence.company.com",
                          List.of()
                  )
                );
    }
}
