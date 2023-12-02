package com.example.maxintegersolver;

import com.example.maxintegersolver.config.exception.LoadAppException;
import com.example.maxintegersolver.config.exception.SPError;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties
public class MaxIntegerSolverApplication {

    public static void main(String[] args) {
        try {
            Dotenv dotenv = Dotenv.load();
            dotenv.entries().forEach(entry -> System.setProperty(entry.getKey(), entry.getValue()));
        } catch (Exception e) {
            throw new LoadAppException(SPError.APP_LOAD_ERROR.getErrorCode(), SPError.APP_LOAD_ERROR.getErrorMessage(), e);
        }

        SpringApplication.run(MaxIntegerSolverApplication.class, args);
    }
}
