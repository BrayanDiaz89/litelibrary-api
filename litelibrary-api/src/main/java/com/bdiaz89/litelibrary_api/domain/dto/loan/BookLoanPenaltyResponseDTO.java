package com.bdiaz89.litelibrary_api.domain.dto.loan;

import com.bdiaz89.litelibrary_api.domain.dto.book.BookResponseDTO;
import com.bdiaz89.litelibrary_api.domain.dto.customer.CustomerResponseDTO;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public record BookLoanPenaltyResponseDTO(
        Long idLoan,
        CustomerResponseDTO customer,
        List<BookResponseDTO> books,
        @JsonFormat(pattern = "yyyy-MM-dd' HORA: 'HH:mm")
        LocalDateTime dateAndTimeOfLoan,
        @JsonFormat(pattern = "yyyy-MM-dd' HORA: 'HH:mm")
        LocalDateTime bookReturnDate,
        Boolean penaltyPaid,
        BigDecimal penaltyAmount
) {
}
