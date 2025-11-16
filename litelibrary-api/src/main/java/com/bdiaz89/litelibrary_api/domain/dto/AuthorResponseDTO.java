package com.bdiaz89.litelibrary_api.domain.dto;

import java.time.LocalDate;

public record AuthorResponseDTO(
        Long idAuthor,
        String nameAuthor,
        LocalDate birthdate,
        LocalDate dateOfDeath
) {
}
