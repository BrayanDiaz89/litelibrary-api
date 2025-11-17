package com.bdiaz89.litelibrary_api.domain.dto.customer;

public record CustomerResponseDTO(
        Long idCustomer,
        String name,
        String lastname,
        String identityDocument
) {
}
