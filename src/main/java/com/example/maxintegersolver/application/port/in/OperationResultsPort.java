package com.example.maxintegersolver.application.port.in;

import com.example.maxintegersolver.domain.OperationDomain;
import java.util.List;

/**
 * The {@code OperationResultsPort} interface specifies the inbound port for retrieving
 * the results of operations. It follows the hexagonal architecture principles, acting
 * as a primary side port that is to be implemented by the core application logic.
 *
 * The port defines the capability of the application core to provide the list of
 * operation results that have been calculated and stored.
 */
public interface OperationResultsPort {

    /**
     * Retrieves a list of {@link OperationDomain} objects, each representing the result
     * of an individual calculation. This method is intended to be used for fetching all
     * results that have been accumulated over time in the application.
     *
     * @return A {@code List} of {@link OperationDomain} instances containing the
     *         historical results of calculations performed by the application.
     */
    List<OperationDomain> getResults();
}
