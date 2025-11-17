package com.bdiaz89.litelibrary_api.service.entitie.mapper;

import com.bdiaz89.litelibrary_api.domain.dto.book.BookRequestDTO;
import com.bdiaz89.litelibrary_api.domain.dto.book.BookResponseDTO;
import com.bdiaz89.litelibrary_api.domain.dto.book.BookUpdateRequestDTO;
import com.bdiaz89.litelibrary_api.domain.entitie.Book;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring", uses = {BookStatusStringMapper.class})
public interface BookMapper {

    @Mapping(source = "id", target = "idBook")
    @Mapping(target = "status", qualifiedByName = "statusToString")
    BookResponseDTO toDto(Book book);

    List<BookResponseDTO> toDto(List<Book> books);

    @Mapping(target = "authors", ignore = true)
    Book toEntitie(BookRequestDTO requestDTO);

    void toUpdateDto(BookUpdateRequestDTO requestDTO, @MappingTarget Book book);

}
