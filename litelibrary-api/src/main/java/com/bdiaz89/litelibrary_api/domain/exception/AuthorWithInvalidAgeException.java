package com.bdiaz89.litelibrary_api.domain.exception;

public class AuthorWithInvalidAgeException extends RuntimeException {
    public AuthorWithInvalidAgeException(String message) {
        super(message);
    }
}
