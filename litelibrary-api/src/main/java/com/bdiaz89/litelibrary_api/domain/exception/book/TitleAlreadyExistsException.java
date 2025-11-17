package com.bdiaz89.litelibrary_api.domain.exception.book;

public class TitleAlreadyExistsException extends RuntimeException {
    public TitleAlreadyExistsException(String message) {
        super(message);
    }
}
