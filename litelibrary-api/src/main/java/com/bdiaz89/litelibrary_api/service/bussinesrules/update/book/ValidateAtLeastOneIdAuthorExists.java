package com.bdiaz89.litelibrary_api.service.bussinesrules.update.book;

import com.bdiaz89.litelibrary_api.domain.dto.book.BookRequestDTO;
import com.bdiaz89.litelibrary_api.domain.dto.book.BookUpdateRequestDTO;
import com.bdiaz89.litelibrary_api.domain.entitie.Author;
import com.bdiaz89.litelibrary_api.domain.exception.book.InvalidAuthorListException;
import com.bdiaz89.litelibrary_api.service.repository.AuthorRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ValidateAtLeastOneIdAuthorExists implements BookUpdateValidator{

    private final AuthorRepository repository;

    public ValidateAtLeastOneIdAuthorExists(AuthorRepository repository) {
        this.repository = repository;
    }

    @Override
    public void validate(BookUpdateRequestDTO request) {
        List<Author> authors = repository.getAuthorsByIds(request.idAuthors());
        if(authors.isEmpty()){
            throw new InvalidAuthorListException("No se encontró ningún autor que coincidiera con los ids suministrados.");
        }
    }
}
