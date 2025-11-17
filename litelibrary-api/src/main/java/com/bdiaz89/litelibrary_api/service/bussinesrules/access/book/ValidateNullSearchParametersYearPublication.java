package com.bdiaz89.litelibrary_api.service.bussinesrules.access.book;

import com.bdiaz89.litelibrary_api.domain.exception.book.InvalidParametersSearchException;
import org.springframework.stereotype.Component;

@Component
public class ValidateNullSearchParametersYearPublication implements BookAccessValidator{

    @Override
    public void validate(Integer startYear, Integer endYear) {
        if (startYear == null || endYear == null){
            throw new InvalidParametersSearchException("Los parametros inicio año de publicación y fin de año de publicación, son obligatorios para la consulta.");
        }
    }
}
