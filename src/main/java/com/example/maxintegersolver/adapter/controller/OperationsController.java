package com.example.maxintegersolver.adapter.controller;

import com.example.maxintegersolver.adapter.controller.model.OperationRequest;
import com.example.maxintegersolver.adapter.controller.model.OperationResponse;
import com.example.maxintegersolver.application.port.in.OperationCalculatorPort;
import com.example.maxintegersolver.application.port.in.OperationResultsPort;
import com.example.maxintegersolver.config.exception.ErrorResponse;
import com.example.maxintegersolver.config.exception.SPError;
import com.example.maxintegersolver.domain.OperationDomain;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * The {@code OperationsController} class handles incoming REST API requests related to operations.
 * It manages endpoints for calculating the maximum non-negative integer k based on given parameters
 * and for retrieving all past calculation results.
 *
 * <p>This controller is annotated with {@link CrossOrigin} to enable CORS (Cross-Origin Resource Sharing).
 * This allows web applications hosted on different domains to interact with this service. The current configuration
 * allows requests from any origin ('*'), accepting any header, and permits all HTTP methods, which is suitable for
 * development environments. For production, it is recommended to restrict the origins and HTTP methods for security reasons.</p>
 */
@RestController
@RequestMapping("/api/v1/operation")
@CrossOrigin(origins = "*", allowedHeaders = "*", methods = {})
public class OperationsController {

    private static final Logger logger = LoggerFactory.getLogger(OperationsController.class);

    private final OperationCalculatorPort calculatePort;
    private final OperationResultsPort resultsPort;

    /**
     * Creates an instance of {@code OperationsController} with necessary ports.
     *
     * @param calculatePort Port for operation calculations.
     * @param resultsPort Port for retrieving operation results.
     */
    public OperationsController(OperationCalculatorPort calculatePort, OperationResultsPort resultsPort) {
        this.calculatePort = calculatePort;
        this.resultsPort = resultsPort;
    }

    /**
     * Endpoint for calculating the maximum non-negative integer k. Validates the request and
     * delegates the calculation to the application service.
     *
     * @param request Contains x, y, and n values for the operation.
     * @param bindingResult Captures validation results for the request.
     * @return ResponseEntity containing the result or error.
     */
    @Operation(
            summary = "Calculate the maximum integer",
            description = "Calculates the maximum non-negative integer k such that 0≤k≤n and k mod x = y. Returns the calculated value or validation errors.",
            responses = {
                    @ApiResponse(
                            responseCode = "201",
                            description = "Calculation successful",
                            content = @Content(schema = @Schema(implementation = OperationResponse.class))
                    ),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Invalid input parameters or calculation error",
                            content = @Content(schema = @Schema(implementation = ErrorResponse.class))
                    )
            }
    )

    @PostMapping
    public ResponseEntity<Object> calculate(@Valid @RequestBody OperationRequest request, BindingResult bindingResult) {
        try {
            logger.info("Received calculation request: {}", request);
            if (bindingResult.hasErrors()) {
                logger.error("Validation errors: {}", bindingResult.getFieldErrors());
                return ResponseEntity.badRequest().body(OperationResponse.badRequest(bindingResult));
            }

            OperationDomain result = calculatePort.calculate(request.toDomain());
            return ResponseEntity.status(HttpStatus.CREATED).body(OperationResponse.of(result, HttpStatus.CREATED));
        } catch (Exception ex) {
            ErrorResponse errorResponse = new ErrorResponse(false, SPError.OPERATION_CONTROLLER_ERROR_CALCULATE.getErrorCode(), SPError.OPERATION_CONTROLLER_ERROR_CALCULATE.getErrorMessage(), ex.getCause());
            logger.error("Calculation error: {}", errorResponse, ex);
            return ResponseEntity.badRequest().body(errorResponse);
        }
    }

    /**
     * Endpoint for retrieving all past calculation results.
     *
     * @return ResponseEntity containing a list of results or an error.
     */
    @Operation(
            summary = "Retrieve all calculation results",
            description = "Fetches all the past results of the calculation operations.",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Results retrieved successfully",
                            content = @Content(schema = @Schema(implementation = List.class))
                    ),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Error occurred while fetching the results",
                            content = @Content(schema = @Schema(implementation = ErrorResponse.class))
                    )
            }
    )
    @GetMapping
    public ResponseEntity<Object> result() {
        try {
            logger.info("Fetching all results");
            List<OperationDomain> results = resultsPort.getResults();
            return ResponseEntity.ok(OperationResponse.of(results, HttpStatus.OK));
        } catch (Exception ex) {
            ErrorResponse errorResponse = new ErrorResponse(false, SPError.OPERATION_CONTROLLER_ERROR_CALCULATE.getErrorCode(), SPError.OPERATION_CONTROLLER_ERROR_CALCULATE.getErrorMessage(), ex.getCause());
            logger.error("Error fetching results: {}", errorResponse, ex);
            return ResponseEntity.badRequest().body(errorResponse);
        }
    }
}
