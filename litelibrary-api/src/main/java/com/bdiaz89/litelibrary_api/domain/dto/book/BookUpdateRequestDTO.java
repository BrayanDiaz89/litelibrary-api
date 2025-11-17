package com.bdiaz89.litelibrary_api.domain.dto.book;

import com.bdiaz89.litelibrary_api.domain.entitie.Genre;
import jakarta.validation.constraints.*;

import java.util.List;

public record BookUpdateRequestDTO(
        @NotEmpty(message = "Debe ingresar una lista valida de autores.")
        @NotNull(message = "La lista de autores no puede ser nula.")
        List<Long> idAuthors,
        @NotNull(message = "Debe ingresar un año de publicación para el libro.")
        @Min(value = 1900, message = "El valor mínimo del año de publicación debe ser 1900.")
        Integer yearOfPublication,
        @NotNull(message = "Debe ingresar un genero para el libro.")
        Genre genre
) {
}
