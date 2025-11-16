package com.bdiaz89.litelibrary_api.web.exception;

public record ErrorResponseDTO(
        String type,
        String message
) {
}
