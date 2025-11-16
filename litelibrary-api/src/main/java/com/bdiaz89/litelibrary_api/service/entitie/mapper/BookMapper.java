package com.bdiaz89.litelibrary_api.service.entitie.mapper;

import com.bdiaz89.litelibrary_api.domain.dto.book.BookRequestDTO;
import com.bdiaz89.litelibrary_api.domain.dto.book.BookResponseDTO;
import com.bdiaz89.litelibrary_api.domain.entitie.Book;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {ListAuthorsBookMapper.class})
public interface BookMapper {

    BookResponseDTO toDto(Book book);

    @Mapping(source = "idAuthors", target = "authors", qualifiedByName = "authorList")
    Book toEntitie(BookRequestDTO requestDTO);

}
