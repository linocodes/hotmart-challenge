package br.com.hotmart.challenge.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI(@Value("${springdoc.version}") String appVersion) {
        // @formatter:off
        return new OpenAPI()
                .info(new Info()
                .title("Challenge Hotmart")
                .version(appVersion)
                .description("This is a sample Foobar server created using springdocs - a library for OpenAPI 3 with spring boot.")
                .termsOfService("http://swagger.io/terms/")
                .license(new License().name("Apache 2.0")
                .url("http://springdoc.org")));
        // @formatter:on
    }

}