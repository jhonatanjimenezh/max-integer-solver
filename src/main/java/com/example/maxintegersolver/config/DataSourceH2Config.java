package com.example.maxintegersolver.config;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Configuration properties class for H2 DataSource.
 * This class is used to bind the properties prefixed with 'spring.datasource' from the application configuration
 * (e.g., application.properties or application.yml) to the fields of this class.
 *
 * <p>Utilizing Lombok annotations for boilerplate code reduction, this class provides getters and setters for each property,
 * enabling easy access and modification of the database connection properties.</p>
 *
 * <p>This configuration class is particularly useful for setting up and customizing the H2 database connection,
 * which is an in-memory database often used for development and testing purposes.</p>
 *
 * <p>Note: The fields in this class should match the properties defined with the 'spring.datasource' prefix
 * in the application configuration files.</p>
 */
@Getter
@Setter
@NoArgsConstructor
@ConfigurationProperties(prefix = "spring.datasource")
public class DataSourceH2Config {

    private String url;
    private String driverClassName;
    private String username;
    private String password;

    // Additional methods or logic can be added here if necessary for advanced configuration.
}
