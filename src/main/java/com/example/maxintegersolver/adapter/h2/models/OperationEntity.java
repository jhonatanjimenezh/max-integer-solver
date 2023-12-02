package com.example.maxintegersolver.adapter.h2.models;

import com.example.maxintegersolver.domain.OperationDomain;
import lombok.*;

import javax.persistence.*;

/**
 * Entity class representing an operation record in the database.
 * Maps the 'operations' table columns to fields in this class.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "operations")
public class OperationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long x;

    @Column(nullable = false)
    private Long y;

    @Column(nullable = false)
    private Long n;

    @Column(nullable = false)
    private Long result;

    /**
     * Converts a {@link OperationDomain} object to an {@link OperationEntity}.
     *
     * @param domain The OperationDomain object to convert.
     * @return The corresponding OperationEntity object.
     */
    public static OperationEntity fromDomain(OperationDomain domain) {
        return OperationEntity.builder()
                .x(domain.getX())
                .y(domain.getY())
                .n(domain.getN())
                .result(domain.getResult())
                .build();
    }

    /**
     * Converts this entity to its domain representation.
     *
     * @return The corresponding OperationDomain object.
     */
    public OperationDomain toDomain() {
        return new OperationDomain(this.x, this.y, this.n, this.result);
    }
}
