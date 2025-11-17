package com.bdiaz89.litelibrary_api.service.bussinesrules.create.author;

import com.bdiaz89.litelibrary_api.domain.dto.author.AuthorRequestDTO;
import com.bdiaz89.litelibrary_api.domain.exception.AuthorWithInvalidAgeException;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.Period;

@Component
public class ValidateConsistentDateOfBirth implements AuthorCreationValidator{
    @Override
    public void validate(AuthorRequestDTO request) {
        LocalDate today = LocalDate.now();
        LocalDate birthDate = request.birthdate();
        int ageAuthor = Period.between(birthDate, today).getYears();
        if(ageAuthor < 12 ){
            throw new AuthorWithInvalidAgeException(String.format("La edad del autor es: %d. Debe ser mayor a 12 años.", ageAuthor));
        }
    }
}
