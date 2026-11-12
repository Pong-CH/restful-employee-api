package org.marketplace.restfulemployeeapi.dto;

import jakarta.validation.constraints.*;

import java.math.BigDecimal;
import java.time.LocalDate;

public record UpdateEmployeeRequest(

        @NotBlank(message = "Name is required")
        @Size(min = 2, max = 100, message = "Name must be between 2 and 100 characters")
        String name,


        @Email(message = "Invalid email format")
        String email,


        @Positive(message = "Salary must be greater then zero")
        BigDecimal salary,


        LocalDate hireDate,


        Boolean isActive
) {
}
