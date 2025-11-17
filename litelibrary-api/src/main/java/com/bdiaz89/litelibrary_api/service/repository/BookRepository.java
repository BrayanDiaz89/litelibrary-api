package com.bdiaz89.litelibrary_api.service.repository;

import com.bdiaz89.litelibrary_api.domain.dto.book.BookRequestDTO;
import com.bdiaz89.litelibrary_api.domain.dto.book.BookResponseDTO;
import com.bdiaz89.litelibrary_api.domain.dto.book.BookUpdateRequestDTO;
import com.bdiaz89.litelibrary_api.domain.entitie.Book;
import com.bdiaz89.litelibrary_api.domain.entitie.Genre;
import com.bdiaz89.litelibrary_api.domain.entitie.StatusBook;

import java.util.List;

public interface BookRepository {
    BookResponseDTO create(BookRequestDTO request);

    boolean existsByTitle(BookRequestDTO request);

    boolean existsByISBN(BookRequestDTO request);

    List<BookResponseDTO> findAll();

    Book findById(Long id);

    boolean existsById(Long id);

    BookResponseDTO findByIdResponse(Long id);

    List<BookResponseDTO> findByTitleOrNameAuthorOrYearPublicationOrGenre(String title, String nameAuthor, Integer yearPublication, Genre genre);

    List<BookResponseDTO> findByBetweenYearPublication(Integer startYear, Integer endYear);

    BookResponseDTO update(Long id, BookUpdateRequestDTO request);

    void delete(Long id);

    void updateStatusBook(Long id, StatusBook status);

}
