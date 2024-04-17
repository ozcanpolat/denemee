package com.example.servicevirtualization.config;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {
    @Bean
    public GroupedOpenApi publicApi() {
        return GroupedOpenApi.builder()
                .group("spring")
                .packagesToScan("com.example.servicevirtualization.controller")  // Corrected package name
                .pathsToMatch("/api/**")
                .build();
    }
}

