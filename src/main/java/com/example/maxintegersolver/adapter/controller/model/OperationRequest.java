package com.example.maxintegersolver.adapter.controller.model;

import com.example.maxintegersolver.domain.OperationDomain;
import com.example.maxintegersolver.domain.util.ValidationMessages;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * Data transfer object for operation requests.
 * This class encapsulates the input data needed to perform the operation calculation.
 */
@Data
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public class OperationRequest {

    /**
     * The value of 'x' for the calculation.
     * Must not be null, must be greater than or equal to -1, and must not exceed {@link Integer#MAX_VALUE}.
     */
    @NotNull(message = ValidationMessages.NOT_NULL_X)
    @Min(value = -1, message = ValidationMessages.MIN_VALUE_X)
    @Max(value = Integer.MAX_VALUE, message = ValidationMessages.MAX_VALUE_X)
    private Long x;

    /**
     * The value of 'y' for the calculation.
     * Must not be null, must be greater than or equal to -1, and must not exceed {@link Integer#MAX_VALUE}.
     */
    @NotNull(message = ValidationMessages.NOT_NULL_Y)
    @Min(value = -1, message = ValidationMessages.MIN_VALUE_Y)
    @Max(value = Integer.MAX_VALUE, message = ValidationMessages.MAX_VALUE_Y)
    private Long y;

    /**
     * The value of 'n' for the calculation.
     * Must not be null, must be greater than or equal to -1, and must not exceed {@link Integer#MAX_VALUE}.
     */
    @NotNull(message = ValidationMessages.NOT_NULL_N)
    @Min(value = -1, message = ValidationMessages.MIN_VALUE_N)
    @Max(value = Integer.MAX_VALUE, message = ValidationMessages.MAX_VALUE_N)
    private Long n;

    /**
     * Converts this DTO to its corresponding domain entity.
     *
     * @return An {@link OperationDomain} instance representing the operation parameters.
     */
    public OperationDomain toDomain() {
        return OperationDomain.builder()
                .x(this.x)
                .y(this.y)
                .n(this.n)
                .build();
    }
}
