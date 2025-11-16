package com.bdiaz89.litelibrary_api.domain.dto.book;

import com.bdiaz89.litelibrary_api.domain.entitie.Genre;
import jakarta.validation.constraints.*;

import java.util.List;

public record BookRequestDTO(
        @NotBlank(message = "Debe ingresar un título para el libro.")
        String title,
        @NotEmpty(message = "Debe ingresar una lista valida de autores.")
        @NotNull(message = "La lista de autores no puede ser nula.")
        List<Long> idAuthors,
        @NotBlank(message = "Debe ingresar un ISBN para el libro.")
        String ISBN,
        @NotNull(message = "Debe ingresar un año de publicación para el libro.")
        @Min(value = 1900, message = "El valor mínimo del año de publicación debe ser 1900.")
        Integer yearOfPublication,
        @NotNull(message = "Debe ingresar un genero para el libro.")
        Genre genre
) {
}
