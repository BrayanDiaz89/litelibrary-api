package com.bdiaz89.litelibrary_api.service.entitie;

import com.bdiaz89.litelibrary_api.domain.dto.book.BookRequestDTO;
import com.bdiaz89.litelibrary_api.domain.dto.book.BookResponseDTO;
import com.bdiaz89.litelibrary_api.service.bussinesrules.create.book.BookCreationValidator;
import com.bdiaz89.litelibrary_api.service.repository.AuthorRepository;
import com.bdiaz89.litelibrary_api.service.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final List<BookCreationValidator> creationValidators;

    public BookService(BookRepository bookRepository, AuthorRepository authorRepository, List<BookCreationValidator> creationValidators) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
        this.creationValidators = creationValidators;
    }


    public BookResponseDTO createBook(BookRequestDTO request) {
        creationValidators.forEach(v-> v.validate(request));
        return bookRepository.create(request);
    }
}
