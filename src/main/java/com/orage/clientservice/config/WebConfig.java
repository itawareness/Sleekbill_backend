package com.orage.clientservice.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // Apply CORS to all endpoints
                .allowedOrigins(getAllowedOrigins()) // Call method to get allowed origins
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                .allowCredentials(true);
    }

    private String[] getAllowedOrigins() {
        return new String[] {
            "http://localhost:4200"            
        };
    }
}
