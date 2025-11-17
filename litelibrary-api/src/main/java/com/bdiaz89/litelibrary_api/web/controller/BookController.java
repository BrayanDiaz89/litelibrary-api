package com.bdiaz89.litelibrary_api.web.controller;

import com.bdiaz89.litelibrary_api.domain.dto.book.BookRequestDTO;
import com.bdiaz89.litelibrary_api.domain.dto.book.BookResponseDTO;
import com.bdiaz89.litelibrary_api.domain.dto.book.BookUpdateRequestDTO;
import com.bdiaz89.litelibrary_api.domain.entitie.Genre;
import com.bdiaz89.litelibrary_api.service.entitie.BookService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {

    private final BookService service;

    public BookController(BookService service) {
        this.service = service;
    }

    @PostMapping("/create")
    public ResponseEntity<BookResponseDTO> create(@RequestBody @Valid BookRequestDTO request,
                                                  UriComponentsBuilder uri){
        BookResponseDTO bookCreated = service.createBook(request);
        URI url = uri.path("/book/{id}").buildAndExpand(bookCreated.idBook()).toUri();
        return ResponseEntity.created(url).body(bookCreated);
    }

    @GetMapping("/all")
    public ResponseEntity<List<BookResponseDTO>> getAllBooks(){
        return ResponseEntity.ok(service.getAllBooks());
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookResponseDTO> getBookById(@PathVariable Long id){
        return ResponseEntity.ok(service.getBookById(id));
    }

    @GetMapping("/search")
    public ResponseEntity<List<BookResponseDTO>> getBooksByTitleOrNameAuthorOrYearPublicationOrGenre(
            @RequestParam(value = "title", required = false) String title,
            @RequestParam(value = "nameAuthor", required = false) String nameAuthor,
            @RequestParam(value = "yearPublication", required = false) Integer yearPublication,
            @RequestParam(value = "genre", required = false) Genre genre
            ){
        return ResponseEntity.ok(service.getBooksByTitleOrNameAuthorOrYearPublicationOrGenre(title, nameAuthor,yearPublication, genre));
    }

    @GetMapping("/search/yearpublication")
    public ResponseEntity<List<BookResponseDTO>> getBooksByBetweenYearPublication(
            @RequestParam(value = "startYear") Integer startYear,
            @RequestParam(value = "endYear") Integer endYear
    ){
        return ResponseEntity.ok(service.getBooksByBetweenYearPublication(startYear, endYear));
    }

    @PutMapping("/{id}")
    public ResponseEntity<BookResponseDTO> updateBook(@PathVariable Long id,
                                                      @RequestBody @Valid BookUpdateRequestDTO request){
        return ResponseEntity.ok(service.updateBook(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id){
        service.deleteBook(id);
        return ResponseEntity.noContent().build();
    }
}
