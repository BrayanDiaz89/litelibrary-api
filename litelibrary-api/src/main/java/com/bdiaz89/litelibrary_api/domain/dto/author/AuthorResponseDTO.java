package com.bdiaz89.litelibrary_api.domain.dto.author;

import java.time.LocalDate;

public record AuthorResponseDTO(
        Long idAuthor,
        String nameAuthor,
        LocalDate birthdate,
        LocalDate dateOfDeath
) {
}
