package com.bdiaz89.litelibrary_api.service.bussinesrules.update.book;

import com.bdiaz89.litelibrary_api.domain.dto.book.BookUpdateRequestDTO;
import com.bdiaz89.litelibrary_api.domain.exception.book.PublicationYearIsNotValidException;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class ValidateYearPublicationIsPastOrPresent implements BookUpdateValidator {

    @Override
    public void validate(BookUpdateRequestDTO request) {
        int yearActually = LocalDate.now().getYear();
        if(yearActually < request.yearOfPublication()){
            throw new PublicationYearIsNotValidException("El año de publicación no debe ser mayor al actual.");
        }
    }
}
