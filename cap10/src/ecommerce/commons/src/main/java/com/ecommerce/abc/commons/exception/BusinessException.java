package com.ecommerce.abc.commons.exception;

import org.springframework.http.HttpStatus;

public class BusinessException extends Projeto1Exception {
    public BusinessException(String message, Object... args) {
        super(HttpStatus.UNPROCESSABLE_ENTITY, message, args);
    }
}
