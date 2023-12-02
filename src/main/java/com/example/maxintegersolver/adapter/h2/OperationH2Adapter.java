package com.example.maxintegersolver.adapter.h2;

import com.example.maxintegersolver.adapter.h2.models.OperationEntity;
import com.example.maxintegersolver.application.port.out.OperationStorageRepository;
import com.example.maxintegersolver.config.exception.DataBaseException;
import com.example.maxintegersolver.config.exception.GenericException;
import com.example.maxintegersolver.config.exception.SPError;
import com.example.maxintegersolver.domain.OperationDomain;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Adapter class for handling operation-related database interactions.
 * Implements the OperationStorageRepository interface.
 * Provides methods to save and retrieve operation records using H2 database.
 */
@Component
public class OperationH2Adapter implements OperationStorageRepository {

    private static final Logger logger = LoggerFactory.getLogger(OperationH2Adapter.class);
    private final OperationH2Repository repository;

    /**
     * Constructor for dependency injection of the OperationH2Repository.
     * @param operationRepository The H2 repository interface for operations.
     */
    public OperationH2Adapter(OperationH2Repository operationRepository) {
        this.repository = operationRepository;
    }

    /**
     * Saves an operation domain object to the database.
     *
     * @param domain The operation domain object to save.
     * @return The saved operation domain object.
     * @throws DataBaseException if any database operation fails.
     */
    @Override
    @Transactional
    public OperationDomain save(OperationDomain domain) {
        try {
            logger.info("Attempting to save operation: {}", domain);
            OperationEntity entity = OperationEntity.fromDomain(domain);
            OperationEntity savedEntity = repository.save(entity);
            logger.info("Operation saved successfully: {}", savedEntity.toDomain());
            return savedEntity.toDomain();
        } catch (Exception e) {
            logger.error("Error saving operation: {}", e.getMessage());
            throw new DataBaseException(SPError.OPERATION_ADAPTER_SAVE_ERROR.getErrorCode(), SPError.OPERATION_ADAPTER_SAVE_ERROR.getErrorMessage(), e);
        }
    }

    /**
     * Retrieves all operation domain objects from the database.
     *
     * @return A list of operation domain objects.
     * @throws DataBaseException if any database operation fails.
     */
    @Override
    @Transactional(readOnly = true)
    public List<OperationDomain> getAll() {
        try {
            logger.info("Retrieving all operations from the database");
            return repository.findAll().stream()
                    .map(OperationEntity::toDomain)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            logger.error("Error retrieving operations: {}", e.getMessage());
            throw new DataBaseException(SPError.OPERATION_ADAPTER_FIND_ERROR.getErrorCode(), SPError.OPERATION_ADAPTER_FIND_ERROR.getErrorMessage(), e);
        }
    }
}
