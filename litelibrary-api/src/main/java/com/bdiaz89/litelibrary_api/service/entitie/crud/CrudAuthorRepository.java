package com.bdiaz89.litelibrary_api.service.entitie.crud;

import com.bdiaz89.litelibrary_api.domain.dto.author.AuthorRequestDTO;
import com.bdiaz89.litelibrary_api.domain.dto.author.AuthorResponseDTO;
import com.bdiaz89.litelibrary_api.domain.dto.author.AuthorUpdateDateOfDeathDTO;
import com.bdiaz89.litelibrary_api.domain.dto.author.AuthorWithListBooksDTO;
import com.bdiaz89.litelibrary_api.domain.entitie.Author;
import com.bdiaz89.litelibrary_api.domain.entitie.Book;
import com.bdiaz89.litelibrary_api.domain.exception.AuthorDoesNotExistsException;
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

    @Override
    public List<AuthorResponseDTO> findAll() {
        return mapper.toDto(authors);
    }

    @Override
    public boolean existsByNameAndLastName(AuthorRequestDTO request) {
        return authors.stream()
                .anyMatch(a ->
                        a.getNameAuthor().equalsIgnoreCase(request.name())
                        && a.getLastnameAuthor().equalsIgnoreCase(request.lastname()));
    }

    @Override
    public List<AuthorWithListBooksDTO> findAllWithBooks() {
        return mapper.toDtoBooks(authors);
    }

    @Override
    public void associateBookWithAnAuthor(Long idAuthor, Book book) {
        Author author = findById(idAuthor);
        author.getBooks().add(book);
    }

    @Override
    public Author findById(Long id) {
        return authors.stream()
                .filter(a -> a.getIdAuthor().equals(id))
                .findFirst()
                .orElseThrow(
                        () -> new AuthorDoesNotExistsException(String.format("El autor con id %d, no existe.", id)
                ));
    }

    @Override
    public AuthorResponseDTO findByIdResponse(Long id) {
        Author author = findById(id);
        return mapper.toDto(author);
    }

    @Override
    public AuthorWithListBooksDTO findByIdResponseWithBooks(Long id) {
        Author author = findById(id);
        return mapper.toDtoBooks(author);
    }

    @Override
    public List<AuthorWithListBooksDTO> findAllByNameOrLastnameOrBirthYearOrDeathYear(String name, String lastname, Integer birthYear, Integer deathYear) {
        return authors.stream()
                .filter(a -> name == null || a.getNameAuthor().equalsIgnoreCase(name))
                .filter(a -> lastname == null || a.getLastnameAuthor().equalsIgnoreCase(lastname))
                .filter(a -> birthYear == null || a.getBirthdate().getYear() == birthYear)
                .filter(a -> deathYear == null ||
                        (a.getDateOfDeath() != null && a.getDateOfDeath().getYear() == deathYear))
                .map(mapper::toDtoBooks)
                .toList();
    }

    @Override
    public List<AuthorWithListBooksDTO> findAuthorsByBirthDate(Integer startBirthyear, Integer endBirthyear) {
        return authors.stream()
                .filter(a-> {
                    int year = a.getBirthdate().getYear();
                    return year >= startBirthyear && year <= endBirthyear;
                })
                .map(mapper::toDtoBooks)
                .toList();
    }

    @Override
    public AuthorResponseDTO updateAuthor(Long id, AuthorRequestDTO request) {
        Author author = findById(id);
        mapper.updateAuthorFromRequest(request, author);
        return mapper.toDto(author);
    }

    @Override
    public AuthorResponseDTO updateAuthorFieldDateOfDeath(Long id, AuthorUpdateDateOfDeathDTO request) {
        Author author = findById(id);
        mapper.updateAuthorFieldDateOfDeath(request, author);
        return mapper.toDto(author);
    }

    @Override
    public void delete(Long id) {
        Author author = findById(id);
        authors.remove(author);
    }

    @Override
    public boolean existsById(Long id) {
        return authors.stream()
                .anyMatch(a -> a.getIdAuthor().equals(id));
    }

    @Override
    public List<Author> getAuthorsByIds(List<Long> ids) {
        return authors.stream()
                .filter(a-> ids.contains(a.getIdAuthor()))
                .toList();
    }

}

