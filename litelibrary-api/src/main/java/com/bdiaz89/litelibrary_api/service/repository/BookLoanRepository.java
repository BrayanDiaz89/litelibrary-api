package com.bdiaz89.litelibrary_api.service.repository;

import com.bdiaz89.litelibrary_api.domain.dto.loan.BookLoanPenaltyResponseDTO;
import com.bdiaz89.litelibrary_api.domain.dto.loan.BookLoanRequestDTO;
import com.bdiaz89.litelibrary_api.domain.dto.loan.BookLoanResponseDTO;
import com.bdiaz89.litelibrary_api.domain.entitie.BookLoan;

import java.util.List;

public interface BookLoanRepository {

    BookLoanResponseDTO create(BookLoanRequestDTO request);

    List<BookLoanPenaltyResponseDTO> findAll();

    BookLoanPenaltyResponseDTO findByIdResponse(Long id);

    BookLoan findById(Long id);

}