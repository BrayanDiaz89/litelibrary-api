package com.bdiaz89.litelibrary_api.domain.dto;

import com.bdiaz89.litelibrary_api.domain.entitie.Genre;
import com.bdiaz89.litelibrary_api.domain.entitie.StatusBook;

public record BookForAuthorResponseDTO(
        String title,
        String ISBN,
        Integer yearOfPublication,
        Genre genre
) {
}
