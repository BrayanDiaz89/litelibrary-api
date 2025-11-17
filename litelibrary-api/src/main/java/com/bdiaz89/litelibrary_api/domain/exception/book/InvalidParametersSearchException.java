package com.bdiaz89.litelibrary_api.domain.exception.book;

public class InvalidParametersSearchException extends RuntimeException {
    public InvalidParametersSearchException(String message) {
        super(message);
    }
}
