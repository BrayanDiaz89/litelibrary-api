package com.bdiaz89.litelibrary_api.domain.dto.customer;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record CustomerRequestDTO(
        @NotBlank(message = "El nombre del cliente no puede ser vacío.")
        String name,
        @NotBlank(message = "El apellido del cliente no puede ser vacío")
        String lastname,
        @NotNull(message = "La identificación del cliente no puede ser vacío")
        @Pattern(regexp = "^\\d{6,10}$", message = "El documento debe tener de 6 a 10 dígitos.")
        String identityDocument
) {
}
