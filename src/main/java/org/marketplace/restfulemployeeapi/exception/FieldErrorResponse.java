package org.marketplace.restfulemployeeapi.exception;

import lombok.Builder;

@Builder
public record FieldErrorResponse(

        String field,

        String message
) {
}
