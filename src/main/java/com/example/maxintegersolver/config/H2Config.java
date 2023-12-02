package com.example.maxintegersolver.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

/**
 * Configuration class for setting up the H2 database DataSource.
 * This class enables configuration properties specifically for the H2 database and creates a {@link DataSource} bean.
 *
 * <p>By enabling {@link EnableConfigurationProperties} with {@link DataSourceH2Config},
 * this class leverages the properties defined in {@link DataSourceH2Config} to configure the database connection.</p>
 *
 * <p>The method {@link #dataSource()} constructs and configures a {@link DriverManagerDataSource} instance
 * using the properties from {@link DataSourceH2Config}, thereby setting up the connection details for the H2 database.</p>
 *
 * <p>This setup is essential for applications using an H2 database, particularly for development and testing environments,
 * where an in-memory or file-based lightweight database is preferable.</p>
 */
@Configuration
@EnableConfigurationProperties(DataSourceH2Config.class)
public class H2Config {

    private final DataSourceH2Config dataSourceH2Config;

    /**
     * Constructor for {@link H2Config}, initializing it with the specified {@link DataSourceH2Config}.
     *
     * @param dataSourceH2Config The configuration properties for H2 DataSource.
     */
    public H2Config(DataSourceH2Config dataSourceH2Config) {
        this.dataSourceH2Config = dataSourceH2Config;
    }

    /**
     * Creates and configures a {@link DataSource} bean for the H2 database.
     * The {@link DataSource} is configured based on the properties provided in {@link DataSourceH2Config}.
     *
     * @return Configured {@link DataSource} instance for the H2 database.
     */
    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(dataSourceH2Config.getDriverClassName());
        dataSource.setUrl(dataSourceH2Config.getUrl());
        dataSource.setUsername(dataSourceH2Config.getUsername());
        dataSource.setPassword(dataSourceH2Config.getPassword());
        return dataSource;
    }
}
