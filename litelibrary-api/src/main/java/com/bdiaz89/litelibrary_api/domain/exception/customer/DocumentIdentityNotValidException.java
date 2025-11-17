package com.bdiaz89.litelibrary_api.domain.exception.customer;

public class DocumentIdentityNotValidException extends RuntimeException {
    public DocumentIdentityNotValidException(String message) {
        super(message);
    }
}
