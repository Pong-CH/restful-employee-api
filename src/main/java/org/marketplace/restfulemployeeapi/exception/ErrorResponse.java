package org.marketplace.restfulemployeeapi.exception;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Builder
public record ErrorResponse<T>(

        Boolean status,

        Integer code,

        String message,

        List<FieldErrorResponse> errors,

        LocalDateTime timestamp
) {
}
