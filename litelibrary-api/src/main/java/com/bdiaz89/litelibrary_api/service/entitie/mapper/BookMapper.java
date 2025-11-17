package com.bdiaz89.litelibrary_api.service.entitie.mapper;

import com.bdiaz89.litelibrary_api.domain.dto.book.BookRequestDTO;
import com.bdiaz89.litelibrary_api.domain.dto.book.BookResponseDTO;
import com.bdiaz89.litelibrary_api.domain.entitie.Book;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {})
public interface BookMapper {

    @Mapping(source = "id", target = "idBook")
    BookResponseDTO toDto(Book book);

    @Mapping(target = "authors", ignore = true)
    Book toEntitie(BookRequestDTO requestDTO);

}
