package com.bdiaz89.litelibrary_api.domain.dto.loan;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record BookLoanRequestDTO(
        @NotNull(message = "El id del cliente no debe ser nulo.")
        Long idCustomer,
        @NotEmpty(message = "La lista de libros a prestar no debe ser vacía.")
        @NotNull(message = "La lista de ids, para los books, no debe ser nula.")
        List<Long> idBooks
) {
}
