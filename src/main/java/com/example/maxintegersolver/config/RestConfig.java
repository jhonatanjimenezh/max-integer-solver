package com.example.maxintegersolver.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.Collections;

/**
 * Configuration class for REST API settings.
 *
 * <p>This class contains configuration settings that affect the behavior of the REST APIs,
 * particularly concerning Cross-Origin Resource Sharing (CORS) settings. The configuration
 * defined in this class is intended to be applied globally across all controllers in the application.</p>
 */
@Configuration
public class RestConfig {

    /**
     * Defines a CORS filter bean to allow cross-origin requests.
     *
     * <p>This method creates and configures a {@link CorsFilter} with a set of predefined settings.
     * It allows credentials and permits requests from all origins, headers, and methods. This setup
     * is suitable for development environments but should be carefully reviewed and potentially restricted
     * for production deployments for security reasons.</p>
     *
     * @return the configured {@link CorsFilter} instance
     */
    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true); // Allow credentials to be included in the CORS requests.
        config.setAllowedOriginPatterns(Collections.singletonList("*")); // Allow all origins.
        config.setAllowedHeaders(Collections.singletonList("*")); // Allow all headers.
        config.setAllowedMethods(Collections.singletonList("*")); // Allow all HTTP methods.
        source.registerCorsConfiguration("/**", config); // Apply these settings to all paths.
        return new CorsFilter(source);
    }
}
