package com.bdiaz89.litelibrary_api.domain.exception.book;

public class BookDoesNotExistsException extends RuntimeException {
    public BookDoesNotExistsException(String message) {
        super(message);
    }
}
