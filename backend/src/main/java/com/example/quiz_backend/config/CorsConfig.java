/*
 Date: 02/07/2026
 Name: Bella
 File Path: config/CorsConfig.java
 Function: Configures Cross-Origin Resource Sharing (CORS) for the backend API.
           Allows the Android app to access backend services.
*/

package com.example.quiz_backend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/*
 This class is used to fix CORS (Cross-Origin) issues.
 It allows the frontend (Android app) to call backend APIs.
*/

@Configuration // Marks this as a configuration class (Spring will load it automatically)
public class CorsConfig {

    // Create a CORS configuration bean
    @Bean
    public WebMvcConfigurer corsConfigurer() {

        return new WebMvcConfigurer() {

            // Configure CORS rules
            @Override
            public void addCorsMappings(CorsRegistry registry) {

                registry.addMapping("/**")
                        // Allow all API endpoints

                        .allowedOrigins("*")
                        // Allow all frontend sources (Android app)

                        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                        // Allow these HTTP request types

                        .allowedHeaders("*");
                // Allow all request headers
            }
        };
    }
}