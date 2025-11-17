package com.bdiaz89.litelibrary_api.domain.exception.customer;

public class CustomerDoesNotExistsException extends RuntimeException {
    public CustomerDoesNotExistsException(String message) {
        super(message);
    }
}
