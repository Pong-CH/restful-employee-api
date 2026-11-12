package org.marketplace.restfulemployeeapi.domain;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(
            nullable = false,
            check = @CheckConstraint(
                    constraint = "Salary > 0"
            ),
            precision = 10,
            scale = 2
    )
    private BigDecimal salary;

    private LocalDate hireDate;

    private Boolean isActive;

}
