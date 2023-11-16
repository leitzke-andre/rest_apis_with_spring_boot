package dev.leitzke.rest_apis_with_spring_boot.config;

import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenAPIConfig {

    @Bean
    OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Spring Boot with Rest Course")
                        .version("v1")
                        .description("No description here.")
                        .termsOfService("io.swagger.v3.oas.annotations.info")
                        .license(new License()
                                .name("MIT")
                                .url("https://github.com/leitzke-andre/rest_apis_with_spring_boot/blob/main/LICENSE")
                        ));
    }
}
