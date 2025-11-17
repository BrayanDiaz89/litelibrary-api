package com.bdiaz89.litelibrary_api.service.bussinesrules.access.book;

import com.bdiaz89.litelibrary_api.domain.exception.book.InvalidParametersSearchException;
import com.bdiaz89.litelibrary_api.domain.exception.book.PublicationYearIsNotValidException;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class ValidateInconsistentPublicationYears implements BookAccessValidator{
    @Override
    public void validate(Integer startYear, Integer endYear) {

        int yearActually = LocalDate.now().getYear();

        if(startYear > endYear){
            throw new InvalidParametersSearchException("Fechas incoherentes. La fecha de publicación final debe ser mayor a la inicial.");
        }
        if(yearActually < startYear || yearActually < endYear){
            throw new PublicationYearIsNotValidException("Los años de publicación no pueden ser mayores al año actual.");
        }
    }
}
