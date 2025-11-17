package com.bdiaz89.litelibrary_api.service.repository;

import com.bdiaz89.litelibrary_api.domain.dto.loan.BookLoanRequestDTO;
import com.bdiaz89.litelibrary_api.domain.dto.loan.BookLoanResponseDTO;

public interface BookLoanRepository {

    BookLoanResponseDTO create(BookLoanRequestDTO request);
}