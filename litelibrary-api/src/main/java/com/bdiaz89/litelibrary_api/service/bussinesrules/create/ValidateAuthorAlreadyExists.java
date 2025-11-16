package com.bdiaz89.litelibrary_api.service.bussinesrules.create;

import com.bdiaz89.litelibrary_api.domain.dto.AuthorRequestDTO;
import com.bdiaz89.litelibrary_api.domain.exception.AuthorAlreadyExistsException;
import com.bdiaz89.litelibrary_api.service.repository.AuthorRepository;
import org.springframework.stereotype.Component;

@Component
public class ValidateAuthorAlreadyExists implements AuthorCreationValidator{

    private final AuthorRepository repository;

    public ValidateAuthorAlreadyExists(AuthorRepository repository) {
        this.repository = repository;
    }

    @Override
    public void validate(AuthorRequestDTO request) {
        boolean existsAuthor = repository.existsByNameAndLastName(request);
        if (existsAuthor){
            throw new AuthorAlreadyExistsException(String.format("El autor con nombre %s %s ya ha sido registrado antes.",
                                                   request.name(), request.lastname()));
        }
    }
}
