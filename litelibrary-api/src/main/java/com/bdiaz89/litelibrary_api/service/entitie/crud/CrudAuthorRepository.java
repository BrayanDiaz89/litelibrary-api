package com.bdiaz89.litelibrary_api.service.entitie.crud;

import com.bdiaz89.litelibrary_api.domain.dto.AuthorRequestDTO;
import com.bdiaz89.litelibrary_api.domain.dto.AuthorResponseDTO;
import com.bdiaz89.litelibrary_api.domain.entitie.Author;
import com.bdiaz89.litelibrary_api.service.entitie.mapper.AuthorMapper;
import com.bdiaz89.litelibrary_api.service.repository.AuthorRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class CrudAuthorRepository implements AuthorRepository {

    private final List<Author> authors;
    private final AuthorMapper mapper;
    private final AtomicLong idAuthor = new AtomicLong(0);

    public CrudAuthorRepository(AuthorMapper mapper) {
        this.authors = new ArrayList<>();
        this.mapper = mapper;
    }


    @Override
    public AuthorResponseDTO createAuthor(AuthorRequestDTO request){
        Author author = mapper.toEntitie(request);
        author.setIdAuthor(idAuthor.incrementAndGet());
        authors.add(author);
        return mapper.toDto(author);
    }

}
