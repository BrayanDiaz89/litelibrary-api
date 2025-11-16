package com.bdiaz89.litelibrary_api.service.repository;

import com.bdiaz89.litelibrary_api.domain.dto.AuthorRequestDTO;
import com.bdiaz89.litelibrary_api.domain.dto.AuthorResponseDTO;
import com.bdiaz89.litelibrary_api.domain.dto.AuthorUpdateDateOfDeathDTO;
import com.bdiaz89.litelibrary_api.domain.dto.AuthorWithListBooksDTO;
import com.bdiaz89.litelibrary_api.domain.entitie.Author;
import com.bdiaz89.litelibrary_api.domain.entitie.Book;

import java.util.List;


public interface AuthorRepository {

    AuthorResponseDTO createAuthor(AuthorRequestDTO request);
    List<AuthorResponseDTO> findAll();
    boolean existsByNameAndLastName(AuthorRequestDTO request);
    List<AuthorWithListBooksDTO> findAllWithBooks();
    void associateBookWithAnAuthor(Long idAuthor, Book book);
    Author findById(Long id);
    AuthorResponseDTO findByIdResponse(Long id);
    AuthorWithListBooksDTO findByIdResponseWithBooks(Long id);
    List<AuthorWithListBooksDTO> findAllByNameOrLastnameOrBirthYearOrDeathYear(String name, String lastname, Integer birthYear, Integer deathYear);

    List<AuthorWithListBooksDTO> findAuthorsByBirthDate(Integer startBirthyear, Integer endBirthyear);

    AuthorResponseDTO updateAuthor(Long id, AuthorRequestDTO request);

    AuthorResponseDTO updateAuthorFieldDateOfDeath(Long id, AuthorUpdateDateOfDeathDTO request);

    void delete(Long id);

    boolean existsById(Long id);
}
