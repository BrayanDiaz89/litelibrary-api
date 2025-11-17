package com.bdiaz89.litelibrary_api.service.entitie.crud;

import com.bdiaz89.litelibrary_api.domain.dto.book.BookRequestDTO;
import com.bdiaz89.litelibrary_api.domain.dto.book.BookResponseDTO;
import com.bdiaz89.litelibrary_api.domain.entitie.Author;
import com.bdiaz89.litelibrary_api.domain.entitie.Book;
import com.bdiaz89.litelibrary_api.service.entitie.mapper.BookMapper;
import com.bdiaz89.litelibrary_api.service.repository.BookRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class CrudBookRepository implements BookRepository {

    private final CrudAuthorRepository crudAuthorRepository;
    private final List<Book> books;
    private final BookMapper mapper;
    private final AtomicLong idBook = new AtomicLong(0);

    public CrudBookRepository(CrudAuthorRepository crudAuthorRepository, BookMapper mapper) {
        this.crudAuthorRepository = crudAuthorRepository;
        this.mapper = mapper;
        this.books = new ArrayList<>();
    }

    @Override
    public BookResponseDTO create(BookRequestDTO request) {
        List<Author> authors = crudAuthorRepository.getAuthorsByIds(request.idAuthors());
        Book book = mapper.toEntitie(request);
        book.setId(idBook.incrementAndGet());
        book.setAuthors(authors);
        books.add(book);
        return mapper.toDto(book);
    }
}
