package com.bdiaz89.litelibrary_api.domain.dto.loan;

import java.util.List;

public record BookLoanRequestDTO(
        Long idCustomer,
        List<Long> idBooks
) {
}
