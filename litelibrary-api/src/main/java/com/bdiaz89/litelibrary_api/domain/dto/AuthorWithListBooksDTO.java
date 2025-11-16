package com.bdiaz89.litelibrary_api.domain.dto;

import java.time.LocalDate;
import java.util.List;

public record AuthorWithListBooksDTO(
        Long idAuthor,
        String nameAuthor,
        LocalDate birthdate,
        LocalDate dateOfDeath,
        List<BookForAuthorResponseDTO> books
){
}
