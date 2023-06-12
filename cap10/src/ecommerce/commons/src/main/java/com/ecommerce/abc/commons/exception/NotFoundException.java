package com.ecommerce.abc.commons.exception;

import org.springframework.http.HttpStatus;

public class NotFoundException extends Projeto1Exception {

    public NotFoundException(String message, Object... args) {
        super(HttpStatus.NOT_FOUND, message, args);
    }

}
