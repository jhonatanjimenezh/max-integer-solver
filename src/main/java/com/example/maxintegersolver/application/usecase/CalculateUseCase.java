package com.example.maxintegersolver.application.usecase;

import com.example.maxintegersolver.application.port.in.OperationCalculatorPort;
import com.example.maxintegersolver.application.port.out.OperationStorageRepository;
import com.example.maxintegersolver.config.exception.CustomException;
import com.example.maxintegersolver.config.exception.SPError;
import com.example.maxintegersolver.domain.OperationDomain;
import com.example.maxintegersolver.domain.service.OperationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The {@code CalculateUseCase} class implements the {@link OperationCalculatorPort} interface
 * to handle the calculation of the maximum non-negative integer k, based on the constraints
 * provided in the {@link OperationDomain}. This class acts as an application service,
 * orchestrating the flow of data between the domain layer and the port interfaces. It
 * utilizes the {@link OperationService} for the core calculation logic and
 * {@link OperationStorageRepository} for persisting the results.
 */
public class CalculateUseCase implements OperationCalculatorPort {

    private static final Logger logger = LoggerFactory.getLogger(CalculateUseCase.class);
    private final OperationService service;
    private final OperationStorageRepository repository;

    /**
     * Constructs a new instance of {@code CalculateUseCase} with the given domain service
     * and storage repository.
     *
     * @param service    The domain service responsible for performing the calculation logic.
     * @param repository The storage repository used for persisting operation results.
     */
    public CalculateUseCase(OperationService service, OperationStorageRepository repository) {
        this.service = service;
        this.repository = repository;
    }

    /**
     * Performs the calculation of the maximum non-negative integer k based on the input
     * parameters x, y, and n provided in the {@link OperationDomain}. This method also
     * persists the result and returns the updated domain entity.
     *
     * @param domain An instance of {@link OperationDomain} containing the input parameters.
     * @return The updated {@link OperationDomain} instance with the calculation result.
     * @throws CustomException If an error occurs during the calculation or data persistence.
     */
    @Override
    public OperationDomain calculate(OperationDomain domain) {
        try {
            logger.info("Calculating in CalculateUseCase with the following data: {}", domain);
            Long result = service.calculateMaxK(domain);
            domain.setResult(result);
            OperationDomain savedDomain = repository.save(domain);
            return OperationDomain.builder()
                    .result(savedDomain.getResult())
                    .build();
        } catch (Exception e) {
            logger.error("Error in CalculateUseCase during calculation", e);
            throw new CustomException(SPError.OPERATION_USE_CASE_ERROR_CALCULATE.getErrorCode(), SPError.OPERATION_USE_CASE_ERROR_CALCULATE.getErrorMessage(), e.getCause());
        }
    }
}
