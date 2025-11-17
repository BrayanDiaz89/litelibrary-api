package com.bdiaz89.litelibrary_api.domain.dto.book;

import com.bdiaz89.litelibrary_api.domain.dto.author.AuthorResponseDTO;
import com.bdiaz89.litelibrary_api.domain.entitie.Genre;
import com.bdiaz89.litelibrary_api.domain.entitie.StatusBook;

import java.util.List;

public record BookResponseDTO(
        Long idBook,
        String title,
        List<AuthorResponseDTO> authors,
        String ISBN,
        Integer yearOfPublication,
        Genre genre,
        String status
) {
}
