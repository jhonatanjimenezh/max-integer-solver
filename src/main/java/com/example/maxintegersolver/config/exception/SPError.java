package com.example.maxintegersolver.config.exception;

/**
 * Enumerates standard error codes and messages for consistent error handling across the application.
 * This enumeration centralizes the definitions of error codes and their corresponding messages,
 * promoting uniformity in error responses and simplification of error diagnosis.
 *
 * <p>Each enumerated value represents a specific type of error, associated with a unique error code
 * and a descriptive message. These values can be used throughout the application to ensure a
 * standardized response to different error conditions.</p>
 *
 * <p>Error codes include but are not limited to:</p>
 * <ul>
 *     <li>GENERIC_ERROR: For general, uncontrolled errors.</li>
 *     <li>APP_LOAD_ERROR: Issues encountered during application startup or loading.</li>
 *     <li>DATABASE_CONNECTION_ERROR: Failures in establishing database connections.</li>
 *     <li>INVALID_ARGUMENT_ERROR: Invalid arguments provided to methods or functions.</li>
 *     <li>INVALID_REQUEST_ERROR: Malformed requests such as unreadable or missing message bodies.</li>
 *     <li>INVALID_PARAMS_ERROR: Requests containing invalid or malformed data.</li>
 *     <li>OPERATION_ADAPTER_SAVE_ERROR: Issues saving records to the database.</li>
 *     <li>OPERATION_ADAPTER_FIND_ERROR: Issues retrieving records from the database.</li>
 *     <li>OPERATION_SERVICE_ERROR_CALCULATE: Errors in mathematical operation calculations.</li>
 *     <li>OPERATION_USE_CASE_ERROR_CALCULATE: Failures in business logic or operation execution during calculation use cases.</li>
 *     <li>OPERATION_CONTROLLER_ERROR_CALCULATE: Failures in controller layer during calculation processing.</li>
 *     <li>OPERATION_USE_CASE_ERROR_RESULTS: Failures in business logic or operation execution when retrieving results.</li>
 *     <li>OPERATION_CONTROLLER_ERROR_RESULTS: Failures in controller layer when processing result retrieval.</li>
 * </ul>
 */
public enum SPError {
    GENERIC_ERROR(1000, "General, uncontrolled errors"),
    APP_LOAD_ERROR(1001, "Errors during application loading"),
    DATABASE_CONNECTION_ERROR(1002, "Database connection failures"),
    INVALID_ARGUMENT_ERROR(1003, "Invalid argument provided to a method or function"),
    INVALID_REQUEST_ERROR(1004, "Malformed request such as unreadable or missing message body"),
    INVALID_PARAMS_ERROR(1005, "Malformed request with invalid data submitted"),
    OPERATION_ADAPTER_SAVE_ERROR(1007, "Errors saving records to the database"),
    OPERATION_ADAPTER_FIND_ERROR(1008, "Errors retrieving records from the database"),
    OPERATION_SERVICE_ERROR_CALCULATE(1009, "Errors performing mathematical operation calculations"),
    OPERATION_USE_CASE_ERROR_CALCULATE(1010, "Use case calculation error, indicates failures in business logic or operation execution"),
    OPERATION_CONTROLLER_ERROR_CALCULATE(1011, "Controller calculation error, indicates failures in business logic or operation execution"),
    OPERATION_USE_CASE_ERROR_RESULTS(1012, "Use case results error, indicates failures in business logic or operation execution"),
    OPERATION_CONTROLLER_ERROR_RESULTS(1013, "Controller results error, indicates failures in business logic or operation execution");

    private final int errorCode;
    private final String errorMessage;

    /**
     * Constructs an SPError enum value with the specified error code and message.
     *
     * @param errorCode    The unique code associated with the error.
     * @param errorMessage The human-readable message describing the error.
     */
    SPError(int errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    /**
     * Retrieves the error code of this error.
     *
     * @return The integer code representing the specific error.
     */
    public int getErrorCode() {
        return errorCode;
    }

    /**
     * Retrieves the error message of this error.
     *
     * @return The string message associated with the error.
     */
    public String getErrorMessage() {
        return errorMessage;
    }
}
