package com.example.maxintegersolver.application.port.out;

import com.example.maxintegersolver.domain.OperationDomain;
import java.util.List;

/**
 * The {@code OperationStorageRepository} interface defines the outbound port for
 * persisting operation results. According to hexagonal architecture principles,
 * this port represents the secondary side which is to be adapted to external
 * persistence mechanisms (e.g., databases).
 *
 * Implementations of this port will interact with the data storage layer, ensuring
 * that operation results are stored and retrieved as needed.
 */
public interface OperationStorageRepository {

    /**
     * Persists an {@link OperationDomain} object to the storage mechanism.
     * This method is responsible for saving the result of a calculation.
     *
     * @param domain The {@link OperationDomain} instance to be saved.
     * @return The persisted {@link OperationDomain} instance, typically with
     *         additional information provided by the storage layer, such as a unique identifier.
     */
    OperationDomain save(OperationDomain domain);

    /**
     * Retrieves all persisted {@link OperationDomain} objects from the storage mechanism.
     * This method will fetch the complete set of operation results that have been stored.
     *
     * @return A {@code List} of {@link OperationDomain} instances, representing
     *         all the operation results that are currently stored.
     */
    List<OperationDomain> getAll();

}
