package com.bdiaz89.litelibrary_api.service.entitie.mapper;

import com.bdiaz89.litelibrary_api.domain.dto.AuthorRequestDTO;
import com.bdiaz89.litelibrary_api.domain.dto.AuthorResponseDTO;
import com.bdiaz89.litelibrary_api.domain.entitie.Author;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = {})
public interface AuthorMapper {

    @Mapping(source = "name", target = "nameAuthor")
    @Mapping(source = "lastname", target = "lastnameAuthor")
    Author toEntitie(AuthorRequestDTO request);

    AuthorResponseDTO toDto(Author author);

    List<AuthorResponseDTO> toDto(List<Author> authors);

}
