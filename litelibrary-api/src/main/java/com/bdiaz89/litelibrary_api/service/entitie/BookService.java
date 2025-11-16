package com.bdiaz89.litelibrary_api.service.entitie;

import com.bdiaz89.litelibrary_api.domain.dto.book.BookRequestDTO;
import com.bdiaz89.litelibrary_api.domain.dto.book.BookResponseDTO;
import com.bdiaz89.litelibrary_api.service.repository.AuthorRepository;
import com.bdiaz89.litelibrary_api.service.repository.BookRepository;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    public BookService(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }


    public BookResponseDTO createBook(BookRequestDTO request) {
        return bookRepository.create(request);
    }
}
