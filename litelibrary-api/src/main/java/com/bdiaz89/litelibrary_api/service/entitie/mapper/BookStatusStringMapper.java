package com.bdiaz89.litelibrary_api.service.entitie.mapper;

import com.bdiaz89.litelibrary_api.domain.entitie.StatusBook;
import org.mapstruct.Named;

public class BookStatusStringMapper {

    @Named("statusToString")
    public static String statusToString(StatusBook status) {
        if(status == null) return null;
        return switch (status) {
            case AVAILABLE -> "DISPONIBLE";
            case BORROWED -> "PRESTADO";
        };
    }

}
