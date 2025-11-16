package com.bdiaz89.litelibrary_api.domain.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;

import java.time.LocalDate;

public record AuthorRequestDTO(
        @NotBlank(message = "El nombre del autor no debe venir vacío")
        String name,
        @NotBlank(message = "El apellido del autor no debe venir vacío")
        String lastname,
        @Past(message = "La fecha de nacimiento del autor debe ser una fecha válida.")
        @NotNull(message = "La fecha de nacimiento del autor debe ser ingresada.")
        LocalDate birthdate,
        LocalDate dateOfDeath
        ) {
}
