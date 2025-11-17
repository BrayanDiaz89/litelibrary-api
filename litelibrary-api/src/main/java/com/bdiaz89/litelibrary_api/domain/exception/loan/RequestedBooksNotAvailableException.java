package com.bdiaz89.litelibrary_api.domain.exception.loan;

public class RequestedBooksNotAvailableException extends RuntimeException {
    public RequestedBooksNotAvailableException(String message) {
        super(message);
    }
}
