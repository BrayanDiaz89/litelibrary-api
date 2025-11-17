package com.bdiaz89.litelibrary_api.domain.dto.loan;

import com.bdiaz89.litelibrary_api.domain.dto.book.BookResponseDTO;
import com.bdiaz89.litelibrary_api.domain.dto.customer.CustomerResponseDTO;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public record BookLoanResponseDTO(
        CustomerResponseDTO customer,
        List<BookResponseDTO> books,
        LocalDateTime dateAndTimeOfLoan,
        LocalDate bookReturnDate,
        Boolean penaltyPaid,
        BigDecimal penaltyAmount
) {
}
