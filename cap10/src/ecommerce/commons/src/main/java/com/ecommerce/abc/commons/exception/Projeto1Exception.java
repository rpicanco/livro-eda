package com.ecommerce.abc.commons.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class Projeto1Exception extends RuntimeException {

    private final HttpStatus status;

    public Projeto1Exception(HttpStatus status, String message, Object... args) {
        super(String.format(message, args), null);
        this.status = status;
    }

    public Projeto1Exception(Throwable cause, HttpStatus status, String message, Object... args) {
        super(String.format(message, args), cause);
        this.status = status;
    }
}
