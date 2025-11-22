package com.bdiaz89.litelibrary_api.service.entitie;

import com.bdiaz89.litelibrary_api.domain.dto.book.BookRequestDTO;
import com.bdiaz89.litelibrary_api.domain.dto.book.BookResponseDTO;
import com.bdiaz89.litelibrary_api.domain.dto.book.BookUpdateRequestDTO;
import com.bdiaz89.litelibrary_api.domain.entitie.Genre;
import com.bdiaz89.litelibrary_api.domain.exception.book.BookDoesNotExistsException;
import com.bdiaz89.litelibrary_api.service.bussinesrules.access.book.BookAccessValidator;
import com.bdiaz89.litelibrary_api.service.bussinesrules.create.book.BookCreationValidator;
import com.bdiaz89.litelibrary_api.service.bussinesrules.update.book.BookUpdateValidator;
import com.bdiaz89.litelibrary_api.service.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    private final BookRepository bookRepository;
    private final List<BookCreationValidator> creationValidators;
    private final List<BookAccessValidator> accessValidators;
    private final List<BookUpdateValidator> updateValidators;

    public BookService(BookRepository bookRepository, List<BookCreationValidator> creationValidators, List<BookAccessValidator> accessValidators, List<BookUpdateValidator> updateValidators) {
        this.bookRepository = bookRepository;
        this.creationValidators = creationValidators;
        this.accessValidators = accessValidators;
        this.updateValidators = updateValidators;
    }


    public BookResponseDTO createBook(BookRequestDTO request) {
        creationValidators.forEach(v-> v.validate(request));
        return bookRepository.create(request);
    }

    public List<BookResponseDTO> getAllBooks() {
        return bookRepository.findAll();
    }

    public BookResponseDTO getBookById(Long id) {
        validateBookExistsById(id);
        return bookRepository.findByIdResponse(id);
    }

    public List<BookResponseDTO> getBooksByTitleOrNameAuthorOrYearPublicationOrGenre(String title, String nameAuthor, Integer yearPublication, Genre genre) {
        return bookRepository.findByTitleOrNameAuthorOrYearPublicationOrGenre(title, nameAuthor, yearPublication, genre);
    }

    public List<BookResponseDTO> getBooksByBetweenYearPublication(Integer startYear, Integer endYear) {
        accessValidators.forEach(v-> v.validate(startYear, endYear));
        return bookRepository.findByBetweenYearPublication(startYear, endYear);
    }

    public BookResponseDTO updateBook(Long id, BookUpdateRequestDTO request) {
        validateBookExistsById(id);
        updateValidators.forEach(v-> v.validate(request));
        return bookRepository.update(id, request);
    }

    public void deleteBook(Long id) {
        validateBookExistsById(id);
        bookRepository.delete(id);
    }

    public void validateBookExistsById(Long id){
        if(!bookRepository.existsById(id)){
            throw new BookDoesNotExistsException("No existe ningún libro con el id suministrado.");
        }
    }

}
