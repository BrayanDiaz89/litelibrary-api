package com.bdiaz89.litelibrary_api.service.bussinesrules.create.book;

import com.bdiaz89.litelibrary_api.domain.dto.book.BookRequestDTO;
import com.bdiaz89.litelibrary_api.domain.entitie.Author;
import com.bdiaz89.litelibrary_api.domain.exception.book.InvalidAuthorListException;
import com.bdiaz89.litelibrary_api.service.repository.AuthorRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ValidateAtLeastOneIdExists implements BookCreationValidator{

    private final AuthorRepository repository;

    public ValidateAtLeastOneIdExists(AuthorRepository repository) {
        this.repository = repository;
    }

    @Override
    public void validate(BookRequestDTO request) {
        List<Author> authors = repository.getAuthorsByIds(request.idAuthors());
        if(authors.isEmpty()){
            throw new InvalidAuthorListException("No se encontró ningún autor que coincidiera con los ids suministrados.");
        }
    }
}
