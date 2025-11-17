package com.bdiaz89.litelibrary_api.domain.exception.loan;

public class InvalidBookListException extends RuntimeException {
    public InvalidBookListException(String message) {
        super(message);
    }
}
