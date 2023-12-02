package com.example.maxintegersolver.application.port.in;

import com.example.maxintegersolver.domain.OperationDomain;

/**
 * The {@code OperationCalculatorPort} interface defines the inbound port for calculating
 * operations within the application core. It adheres to the principles of hexagonal
 * architecture, where this port represents the primary side, which is called by external
 * actors (e.g., adapters).
 *
 * Implementations of this port interface will handle the application-specific business rules
 * for the calculation process.
 */
public interface OperationCalculatorPort {

    /**
     * Calculates the maximum non-negative integer k based on the given operation domain
     * constraints (x, y, n) as per the problem definition.
     *
     * @param operationDomain An instance of {@link OperationDomain} encapsulating the input
     *                        parameters x, y, and n for the calculation.
     * @return An instance of {@link OperationDomain} containing the result of the calculation
     *         with the maximum k value that satisfies the equation k mod x = y where k <= n.
     */
    OperationDomain calculate(OperationDomain operationDomain);
}
