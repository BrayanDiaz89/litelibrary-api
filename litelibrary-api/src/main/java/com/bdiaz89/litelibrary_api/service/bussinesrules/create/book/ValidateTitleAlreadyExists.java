package com.bdiaz89.litelibrary_api.service.bussinesrules.create.book;

import com.bdiaz89.litelibrary_api.domain.dto.book.BookRequestDTO;
import com.bdiaz89.litelibrary_api.domain.exception.book.TitleAlreadyExistsException;
import com.bdiaz89.litelibrary_api.service.repository.BookRepository;
import org.springframework.stereotype.Component;

@Component
public class ValidateTitleAlreadyExists implements BookCreationValidator{

    private final BookRepository repository;

    public ValidateTitleAlreadyExists(BookRepository repository) {
        this.repository = repository;
    }


    @Override
    public void validate(BookRequestDTO request) {
        if(repository.existsByTitle(request)){
            throw new TitleAlreadyExistsException("Ya existe un libro con el título suministrado.");
        }
    }
}
