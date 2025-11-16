package com.bdiaz89.litelibrary_api.service.entitie.mapper;

import com.bdiaz89.litelibrary_api.domain.dto.author.AuthorRequestDTO;
import com.bdiaz89.litelibrary_api.domain.dto.author.AuthorResponseDTO;
import com.bdiaz89.litelibrary_api.domain.dto.author.AuthorUpdateDateOfDeathDTO;
import com.bdiaz89.litelibrary_api.domain.dto.author.AuthorWithListBooksDTO;
import com.bdiaz89.litelibrary_api.domain.entitie.Author;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring", uses = {NameAuthorMapper.class})
public interface AuthorMapper {

    @Mapping(source = "name", target = "nameAuthor")
    @Mapping(source = "lastname", target = "lastnameAuthor")
    Author toEntitie(AuthorRequestDTO request);

    @Mapping(source = "author", target = "nameAuthor", qualifiedByName = "nameCompletedAuthor")
    AuthorResponseDTO toDto(Author author);

    AuthorWithListBooksDTO toDtoBooks(Author author);

    List<AuthorResponseDTO> toDto(List<Author> authors);

    List<AuthorWithListBooksDTO> toDtoBooks(List<Author> authors);

    @Mapping(source = "name", target = "nameAuthor")
    @Mapping(source = "lastname", target = "lastnameAuthor")
    void updateAuthorFromRequest(AuthorRequestDTO request, @MappingTarget Author author);

    void updateAuthorFieldDateOfDeath(AuthorUpdateDateOfDeathDTO request, @MappingTarget Author author);
}
