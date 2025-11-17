package com.bdiaz89.litelibrary_api.service.entitie.crud;

import com.bdiaz89.litelibrary_api.domain.dto.book.BookRequestDTO;
import com.bdiaz89.litelibrary_api.domain.dto.book.BookResponseDTO;
import com.bdiaz89.litelibrary_api.domain.dto.book.BookUpdateRequestDTO;
import com.bdiaz89.litelibrary_api.domain.entitie.Author;
import com.bdiaz89.litelibrary_api.domain.entitie.Book;
import com.bdiaz89.litelibrary_api.domain.entitie.Genre;
import com.bdiaz89.litelibrary_api.domain.entitie.StatusBook;
import com.bdiaz89.litelibrary_api.domain.exception.book.BookDoesNotExistsException;
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
        book.setStatus(StatusBook.AVAILABLE);
        crudAuthorRepository.associateBookWithAnAuthor(authors, book);
        books.add(book);
        return mapper.toDto(book);
    }

    @Override
    public boolean existsByTitle(BookRequestDTO request) {
        return books.stream()
                .anyMatch(b-> b.getTitle().equalsIgnoreCase(request.title()));
    }

    @Override
    public boolean existsByISBN(BookRequestDTO request) {
        return books.stream()
                .anyMatch(b-> b.getISBN().equalsIgnoreCase(request.ISBN()));
    }

    @Override
    public List<BookResponseDTO> findAll() {
        return mapper.toDto(books);
    }

    @Override
    public Book findById(Long id) {
        return books.stream()
                .filter(b-> b.getId().equals(id))
                .findAny()
                .orElseThrow(() -> new BookDoesNotExistsException("No existe un libro con el id suministrado."));
    }

    @Override
    public boolean existsById(Long id) {
        return books.stream()
                .anyMatch(b-> b.getId().equals(id));
    }

    @Override
    public BookResponseDTO findByIdResponse(Long id) {
        Book book = findById(id);
        return mapper.toDto(book);
    }

    @Override
    public List<BookResponseDTO> findByTitleOrNameAuthorOrYearPublicationOrGenre(String title, String nameAuthor, Integer yearPublication, Genre genre) {
        return books.stream()
                .filter(b -> title == null || b.getTitle().equalsIgnoreCase(title))
                .filter(b-> nameAuthor == null ||
                        b.getAuthors().stream().anyMatch(a-> a.getNameAuthor().equalsIgnoreCase(nameAuthor) || a.getLastnameAuthor().equalsIgnoreCase(nameAuthor))
                )
                .filter(b-> yearPublication == null || b.getYearOfPublication().equals(yearPublication))
                .filter(b-> genre == null || b.getGenre().equals(genre))
                .map(mapper::toDto)
                .toList();
    }

    @Override
    public List<BookResponseDTO> findByBetweenYearPublication(Integer startYear, Integer endYear) {
        return books.stream()
                .filter(b-> b.getYearOfPublication() >= startYear && b.getYearOfPublication() <= endYear)
                .map(mapper::toDto)
                .toList();
    }

    @Override
    public BookResponseDTO update(Long id, BookUpdateRequestDTO request) {
        Book book = findById(id);
        mapper.toUpdateDto(request, book);
        return mapper.toDto(book);
    }

    @Override
    public void delete(Long id) {
        Book book = findById(id);
        books.remove(book);
    }

    @Override
    public void updateStatusBook(Long id, StatusBook status) {
        Book book = findById(id);
        book.setStatus(status);
    }
}
