package com.bdiaz89.litelibrary_api.service.bussinesrules.create.book;

import com.bdiaz89.litelibrary_api.domain.dto.book.BookRequestDTO;
import com.bdiaz89.litelibrary_api.domain.exception.book.ISBNAlreadyExistsException;
import com.bdiaz89.litelibrary_api.domain.exception.book.TitleAlreadyExistsException;
import com.bdiaz89.litelibrary_api.service.repository.BookRepository;
import org.springframework.stereotype.Component;

@Component
public class ValidateISBNAlreadyExists implements BookCreationValidator{

    private final BookRepository repository;

    public ValidateISBNAlreadyExists(BookRepository repository) {
        this.repository = repository;
    }


    @Override
    public void validate(BookRequestDTO request) {
        if(repository.existsByISBN(request)){
            throw new ISBNAlreadyExistsException("Ya existe un libro con el ISBN suministrado.");
        }
    }
}
