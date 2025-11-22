package com.bdiaz89.litelibrary_api.domain.exception.loan;

public class LoanDoesNotExistsException extends RuntimeException {
    public LoanDoesNotExistsException(String message) {
        super(message);
    }
}
