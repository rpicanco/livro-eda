package com.ecommerce.abc.commons.handler;

import lombok.Builder;
import lombok.Getter;
import lombok.Singular;
import org.springframework.http.HttpStatus;

import java.util.List;

@Builder
@Getter
public class ApiError {
    @Builder.Default
    private HttpStatus status = HttpStatus.BAD_REQUEST;
    private String message;
    @Singular
    private List<String> errors;
}
