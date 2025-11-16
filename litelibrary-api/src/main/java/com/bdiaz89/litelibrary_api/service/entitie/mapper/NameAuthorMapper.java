package com.bdiaz89.litelibrary_api.service.entitie.mapper;

import com.bdiaz89.litelibrary_api.domain.entitie.Author;
import org.mapstruct.Named;

public class NameAuthorMapper {

    @Named("nameCompletedAuthor")
    public static String nameCompleted(Author author){
        return author.getNameAuthor() + ", " + author.getLastnameAuthor();
    }
}
