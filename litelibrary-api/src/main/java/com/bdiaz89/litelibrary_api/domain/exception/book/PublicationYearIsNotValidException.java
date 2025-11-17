package com.bdiaz89.litelibrary_api.domain.exception.book;

public class PublicationYearIsNotValidException extends RuntimeException {
    public PublicationYearIsNotValidException(String message) {
        super(message);
    }
}
