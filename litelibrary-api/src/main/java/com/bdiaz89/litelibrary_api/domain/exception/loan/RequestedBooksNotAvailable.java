package com.bdiaz89.litelibrary_api.domain.exception.loan;

public class RequestedBooksNotAvailable extends RuntimeException {
    public RequestedBooksNotAvailable(String message) {
        super(message);
    }
}
