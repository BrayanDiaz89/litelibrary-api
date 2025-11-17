package com.bdiaz89.litelibrary_api.domain.exception.book;

public class InvalidAuthorListException extends RuntimeException {
    public InvalidAuthorListException(String message) {
        super(message);
    }
}
