package com.bdiaz89.litelibrary_api.service.entitie;

import com.bdiaz89.litelibrary_api.domain.dto.loan.BookLoanRequestDTO;
import com.bdiaz89.litelibrary_api.domain.dto.loan.BookLoanResponseDTO;
import com.bdiaz89.litelibrary_api.service.bussinesrules.create.loan.LoanCreationValidator;
import com.bdiaz89.litelibrary_api.service.repository.BookLoanRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookLoanService {

    private final BookLoanRepository repository;
    private final List<LoanCreationValidator> creationValidators;

    public BookLoanService(BookLoanRepository repository, List<LoanCreationValidator> creationValidators) {
        this.repository = repository;
        this.creationValidators = creationValidators;
    }


    public BookLoanResponseDTO createLoan(BookLoanRequestDTO request) {
        creationValidators.forEach(v-> v.validate(request));
        return repository.create(request);
    }
}
