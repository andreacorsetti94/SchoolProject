package com.it.demo.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
public class ResourceAlreadyPresentException extends RuntimeException {
    public ResourceAlreadyPresentException() {
        super();
    }

    public ResourceAlreadyPresentException(String message) {
        super(message);
    }

    public ResourceAlreadyPresentException(String message, Throwable cause) {
        super(message, cause);
    }
}