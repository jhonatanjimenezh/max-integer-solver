package com.example.maxintegersolver.domain.service;

import static org.junit.jupiter.api.Assertions.*;

import com.example.maxintegersolver.config.exception.CustomException;
import com.example.maxintegersolver.domain.OperationDomain;
import com.example.maxintegersolver.mocks.MockFactory;
import org.junit.jupiter.api.Test;

/**
 * Unit tests for {@link OperationService}.
 * These tests ensure that the service correctly implements the logic for calculating the maximum non-negative integer k.
 */
class OperationServiceTest {

    private final OperationService operationService = new OperationService();

    /**
     * Test the calculateMaxK method for successful calculation.
     */
    @Test
    void calculateMaxK_Success() {
        OperationDomain domain = MockFactory.getOperationDomainFactory();
        Long result = operationService.calculateMaxK(domain);

        assertEquals(15L, result, "The calculated maxK should be correct for the given input");
    }

    /**
     * Test the calculateMaxK method for handling border case inputs.
     */
    @Test
    void calculateMaxK_BorderCase() {
        OperationDomain domain = MockFactory.getOperationDomainBorderFactory();
        Long result = operationService.calculateMaxK(domain);

        assertEquals(20L, result, "The calculated maxK should handle border cases correctly");
    }

    /**
     * Test the calculateMaxK method for handling invalid inputs.
     */
    @Test
    void calculateMaxK_InvalidInput() {
        OperationDomain domain = MockFactory.getOperationDomainInvalidFactory();

        assertThrows(CustomException.class, () -> operationService.calculateMaxK(domain),
                "A CustomException should be thrown for invalid input");
    }
}
