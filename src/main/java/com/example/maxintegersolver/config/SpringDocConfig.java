package com.example.maxintegersolver.config;

import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.models.info.Info;


/**
 * Configuration class for SpringDoc.
 * This class is used to set up SpringDoc, which provides support for generating API documentation
 * using the OpenAPI 3 specification.
 *
 * <p>The {@link #publicApi()} method configures the GroupedOpenApi bean,
 * specifying which API endpoints should be included in the documentation.
 * This setup is essential for creating a clear and informative API documentation interface,
 * aiding in API testing and integration.</p>
 *
 * <p>The configuration is set to scan the 'com.example.maxintegersolver' package, ensuring that all API endpoints within this package
 * are included in the generated documentation.</p>
 */
@Configuration
public class SpringDocConfig {

    /**
     * Creates a GroupedOpenApi bean for generating API documentation.
     * This bean specifies the API group name and the packages to scan for API endpoints.
     *
     * @return A configured {@link GroupedOpenApi} instance for API documentation generation.
     */
    @Bean
    public GroupedOpenApi publicApi() {
        return GroupedOpenApi.builder()
                .group("Max Integer Solver API")
                .packagesToScan("com.example.maxintegersolver")
                .addOpenApiCustomiser(openApi -> {
                    openApi.info(new Info()
                            .title("Max Integer Solver API")
                            .version("v1")
                            .description("Max Integer Solver es una aplicación Spring Boot desarrollada para resolver el problema de encontrar el máximo entero no negativo `k` tal que `0 ≤ k ≤ n` y `k mod x = y`. Este proyecto implementa una solución algorítmica para el problema descrito en [Codeforces - Problem 1374A](https://codeforces.com/problemset/problem/1374/A) y expone esta funcionalidad a través de una API REST."));
                })
                .build();
    }

}
