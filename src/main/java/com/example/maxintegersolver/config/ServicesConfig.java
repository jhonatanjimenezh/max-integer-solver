package com.example.maxintegersolver.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

/**
 * Configuration class for Services in the application.
 * Utilizes Spring's {@link ComponentScan} annotation to define which packages to scan for Spring beans.
 * This configuration is specifically tailored to scan the 'domain.service' package for components that match the Service naming convention.
 *
 * <p>The use of regex filters in {@link ComponentScan} ensures that only classes with a 'Service' suffix
 * are considered for inclusion as beans in the Spring application context, aligning with the application's architectural design.</p>
 *
 * <p>This focused approach to component scanning supports a clean, modular architecture,
 * promoting the separation of concerns and aiding in maintaining a well-structured and manageable codebase.</p>
 */
@Configuration
@ComponentScan(basePackages = "com.example.maxintegersolver.domain.service",
        includeFilters = {@ComponentScan.Filter(type = FilterType.REGEX, pattern = "^.+Service$")},
        useDefaultFilters = false)
public class ServicesConfig {
    // No additional methods or attributes needed, as this class serves solely as configuration.
}
