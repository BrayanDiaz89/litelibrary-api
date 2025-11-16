package com.bdiaz89.litelibrary_api.domain.dto;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record AuthorUpdateDateOfDeathDTO(
        @NotNull(message = "La fecha de fallecimiento no debe ser nula o vacía.")
        LocalDate dateOfDeath
) {
}
