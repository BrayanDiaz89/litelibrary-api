package com.bdiaz89.litelibrary_api.domain.dto.customer;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record CustomerUpdateDTO(
        @NotBlank(message = "El nombre del cliente no puede ser vacío.")
        String name,
        @NotBlank(message = "El apellido del cliente no puede ser vacío")
        String lastname
) {
}
