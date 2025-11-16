package com.bdiaz89.litelibrary_api.service.entitie.mapper;

import com.bdiaz89.litelibrary_api.domain.entitie.Author;
import com.bdiaz89.litelibrary_api.service.repository.AuthorRepository;
import org.mapstruct.Named;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ListAuthorsBookMapper {

    private final AuthorRepository repository;

    public ListAuthorsBookMapper(AuthorRepository repository) {
        this.repository = repository;
    }

    @Named("authorList")
    public List<Author> authorList(List<Long> ids){
        return repository.getAuthorsByIds(ids);
    }
}

