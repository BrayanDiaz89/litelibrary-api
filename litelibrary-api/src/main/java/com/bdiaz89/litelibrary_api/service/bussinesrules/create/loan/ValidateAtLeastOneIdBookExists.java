package com.bdiaz89.litelibrary_api.service.bussinesrules.create.loan;

import com.bdiaz89.litelibrary_api.domain.dto.loan.BookLoanRequestDTO;
import com.bdiaz89.litelibrary_api.domain.entitie.Book;
import com.bdiaz89.litelibrary_api.domain.exception.loan.InvalidBookListException;
import com.bdiaz89.litelibrary_api.service.repository.BookRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ValidateAtLeastOneIdBookExists implements LoanCreationValidator {

    private final BookRepository repository;

    public ValidateAtLeastOneIdBookExists(BookRepository repository) {
        this.repository = repository;
    }

    @Override
    public void validate(BookLoanRequestDTO request) {
        List<Book> books = repository.getBooksByListId(request.idBooks());
        if(books.isEmpty()){
            throw new InvalidBookListException("No se encontró ningún libro que coincidiera con los ids suministrados.");
        }
    }

}
