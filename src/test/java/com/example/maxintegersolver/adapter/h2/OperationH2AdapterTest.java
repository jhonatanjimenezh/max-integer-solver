package com.example.maxintegersolver.adapter.h2;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import com.example.maxintegersolver.adapter.h2.models.OperationEntity;
import com.example.maxintegersolver.config.exception.DataBaseException;
import com.example.maxintegersolver.domain.OperationDomain;
import com.example.maxintegersolver.mocks.MockFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

/**
 * Unit tests for {@link OperationH2Adapter} class.
 * These tests validate the adapter's interactions with the H2 database, ensuring correct data handling.
 */
@ExtendWith(MockitoExtension.class)
class OperationH2AdapterTest {

    @Mock
    private OperationH2Repository repository;

    @InjectMocks
    private OperationH2Adapter adapter;

    private OperationDomain operationDomain;
    private OperationEntity operationEntity;

    @BeforeEach
    void setUp() {
        operationDomain = MockFactory.getOperationDomainFactory();
        operationEntity = OperationEntity.fromDomain(operationDomain);
    }

    /**
     * Test saving an operation to the database successfully.
     */
    @Test
    void save_Success() {
        when(repository.save(any(OperationEntity.class))).thenReturn(operationEntity);

        OperationDomain result = adapter.save(operationDomain);

        assertNotNull(result, "Result should not be null");
        assertEquals(operationDomain.getX(), result.getX(), "X values should match");
        assertEquals(operationDomain.getY(), result.getY(), "Y values should match");
        assertEquals(operationDomain.getN(), result.getN(), "N values should match");
        assertEquals(operationDomain.getResult(), result.getResult(), "Result values should match");
    }

    /**
     * Test error handling when saving an operation to the database fails.
     */
    @Test
    void save_Error() {
        when(repository.save(any(OperationEntity.class))).thenThrow(new RuntimeException("Database error"));

        assertThrows(DataBaseException.class, () -> adapter.save(operationDomain),
                "DataBaseException should be thrown on save error");
    }

    /**
     * Test retrieving all operations from the database successfully.
     */
    @Test
    void getAll_Success() {
        when(repository.findAll()).thenReturn(List.of(operationEntity));

        List<OperationDomain> result = adapter.getAll();

        assertNotNull(result, "Result list should not be null");
        assertFalse(result.isEmpty(), "Result list should not be empty");
        assertEquals(operationDomain.getX(), result.get(0).getX(), "X values should match");
        assertEquals(operationDomain.getY(), result.get(0).getY(), "Y values should match");
        assertEquals(operationDomain.getN(), result.get(0).getN(), "N values should match");
        assertEquals(operationDomain.getResult(), result.get(0).getResult(), "Result values should match");
    }

    /**
     * Test error handling when retrieving all operations from the database fails.
     */
    @Test
    void getAll_Error() {
        when(repository.findAll()).thenThrow(new RuntimeException("Database error"));

        assertThrows(DataBaseException.class, () -> adapter.getAll(),
                "DataBaseException should be thrown on getAll error");
    }
}
