package dev.leitzke.rest_apis_with_spring_boot;

import dev.leitzke.rest_apis_with_spring_boot.service.MathService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public MathService mathService(){
        return new MathService();
    }
}
