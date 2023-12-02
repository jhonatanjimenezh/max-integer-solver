package com.example.maxintegersolver.application.usecase;

import com.example.maxintegersolver.application.port.in.OperationResultsPort;
import com.example.maxintegersolver.application.port.out.OperationStorageRepository;
import com.example.maxintegersolver.config.exception.CustomException;
import com.example.maxintegersolver.config.exception.SPError;
import com.example.maxintegersolver.domain.OperationDomain;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * The {@code ResultsUseCase} class implements the {@link OperationResultsPort} interface
 * to handle the use case of retrieving results of all performed operations. This class
 * acts as an application service, facilitating the interaction between the application
 * layer and the domain layer. It utilizes {@link OperationStorageRepository} for accessing
 * persisted operation results.
 */
public class ResultsUseCase implements OperationResultsPort {

    private static final Logger logger = LoggerFactory.getLogger(ResultsUseCase.class);
    private final OperationStorageRepository repository;

    /**
     * Constructs a new instance of {@code ResultsUseCase}. This constructor initializes
     * the repository responsible for data retrieval.
     *
     * @param repository The {@link OperationStorageRepository} used to retrieve operation results.
     */
    public ResultsUseCase(OperationStorageRepository repository) {
        this.repository = repository;
    }

    /**
     * Retrieves a list of all {@link OperationDomain} results that have been persisted.
     * It fetches the historical data of operation calculations and is used to provide
     * insight into past computations.
     *
     * @return A {@code List} of {@link OperationDomain} instances, each representing a stored operation result.
     * @throws CustomException If an error occurs during the data retrieval process.
     */
    @Override
    public List<OperationDomain> getResults() {
        try {
            logger.info("Fetching all operation results");
            return this.repository.getAll();
        } catch (Exception e) {
            logger.error("Error fetching operation results", e);
            throw new CustomException(SPError.OPERATION_USE_CASE_ERROR_RESULTS.getErrorCode(), SPError.OPERATION_USE_CASE_ERROR_RESULTS.getErrorMessage(), e.getCause());
        }
    }
}
