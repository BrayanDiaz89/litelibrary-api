package com.bdiaz89.litelibrary_api.domain.exception.book;

public class ISBNAlreadyExistsException extends RuntimeException {
    public ISBNAlreadyExistsException(String message) {
        super(message);
    }
}
