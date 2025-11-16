package com.bdiaz89.litelibrary_api.service.bussinesrules.access;

import com.bdiaz89.litelibrary_api.domain.exception.AuthorDoesNotExistsException;
import com.bdiaz89.litelibrary_api.service.repository.AuthorRepository;
import org.springframework.stereotype.Component;

@Component
public class ValidateAuthorExists implements AuthorAccessValidator {

    private final AuthorRepository repository;

    public ValidateAuthorExists(AuthorRepository repository) {
        this.repository = repository;
    }

    @Override
    public void validate(Long id) {
        boolean authorExists = repository.existsById(id);
        if(id == null || !authorExists){
            throw new AuthorDoesNotExistsException("El autor no fue encontrado. Valide el id enviado.");
        }
    }
}
