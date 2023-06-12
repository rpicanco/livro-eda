package com.ecommerce.abc.commons.exception;

import org.springframework.http.HttpStatus;

public class InternalServerErrorException extends Projeto1Exception {

    public InternalServerErrorException(String message, Object... args) {
        super(HttpStatus.INTERNAL_SERVER_ERROR, message, args);
    }

    public InternalServerErrorException(Throwable cause, String message, Object... args) {
        super(cause, HttpStatus.INTERNAL_SERVER_ERROR, message, args);
    }

}
