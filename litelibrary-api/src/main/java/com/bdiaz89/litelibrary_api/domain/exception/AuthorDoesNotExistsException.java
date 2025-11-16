package com.bdiaz89.litelibrary_api.domain.exception;

public class AuthorDoesNotExistsException extends RuntimeException {
    public AuthorDoesNotExistsException(String message) {
        super(message);
    }
}
