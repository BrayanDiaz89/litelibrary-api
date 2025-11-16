package com.bdiaz89.litelibrary_api.domain.dto.author;

import com.bdiaz89.litelibrary_api.domain.entitie.Genre;

public record BookForAuthorResponseDTO(
        String title,
        String ISBN,
        Integer yearOfPublication,
        Genre genre
) {
}
