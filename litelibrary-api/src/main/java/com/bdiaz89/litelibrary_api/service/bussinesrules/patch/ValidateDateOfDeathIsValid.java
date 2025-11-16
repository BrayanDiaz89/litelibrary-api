package com.bdiaz89.litelibrary_api.service.bussinesrules.patch;

import com.bdiaz89.litelibrary_api.domain.dto.author.AuthorUpdateDateOfDeathDTO;
import com.bdiaz89.litelibrary_api.domain.entitie.Author;
import com.bdiaz89.litelibrary_api.domain.exception.InvalidRecordedDateException;
import com.bdiaz89.litelibrary_api.service.repository.AuthorRepository;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class ValidateDateOfDeathIsValid implements AuthorPatchValidator {

    private final AuthorRepository repository;

    public ValidateDateOfDeathIsValid(AuthorRepository repository) {
        this.repository = repository;
    }

    @Override
    public void validate(Long id, AuthorUpdateDateOfDeathDTO request) {
        Author author = repository.findById(id);
        LocalDate birthDateAuthor = author.getBirthdate();

        if(birthDateAuthor.isAfter(request.dateOfDeath())){
            throw new InvalidRecordedDateException("La fecha de fallecimiento no puede ser menor a la de nacimiento");
        }
    }
}