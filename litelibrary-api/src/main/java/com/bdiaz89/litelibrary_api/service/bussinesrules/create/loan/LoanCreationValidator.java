package com.bdiaz89.litelibrary_api.service.bussinesrules.create.loan;

import com.bdiaz89.litelibrary_api.domain.dto.loan.BookLoanRequestDTO;

public interface LoanCreationValidator {
    void validate(BookLoanRequestDTO request);
}
