package com.example.maxintegersolver.config.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Custom exception class for handling application loading errors.
 * This class extends {@link GenericException} and is used to represent errors that occur during the application load process.
 *
 * <p>It includes additional logging functionality to record the occurrence of the error,
 * capturing both the error code and the error message for better error diagnostics and tracking.</p>
 *
 * <p>Instances of this exception should be thrown when specific loading errors are encountered,
 * allowing for consistent and structured error handling across the application.</p>
 */
public class LoadAppException extends GenericException {

    private static final Logger logger = LoggerFactory.getLogger(LoadAppException.class);

    /**
     * Constructs a new LoadAppException with the specified detail message and error code.
     * Additionally, logs the error message and code.
     *
     * @param errorCode The error code associated with this exception.
     * @param message The detailed message for this exception.
     */
    public LoadAppException(int errorCode, String message) {
        super(errorCode, message);
        logger.error("Exception LoadAppException: code:{}, message:{}", errorCode, message);
    }

    /**
     * Constructs a new LoadAppException with the specified detail message, error code, and cause.
     * Additionally, logs the error message and code.
     *
     * @param errorCode The error code associated with this exception.
     * @param message The detailed message for this exception.
     * @param cause The cause of this exception (a null value is permitted, and indicates that the cause is nonexistent or unknown).
     */
    public LoadAppException(int errorCode, String message, Throwable cause) {
        super(errorCode, message, cause);
        logger.error("Exception LoadAppException: code:{}, message:{}", errorCode, message);
    }
}
