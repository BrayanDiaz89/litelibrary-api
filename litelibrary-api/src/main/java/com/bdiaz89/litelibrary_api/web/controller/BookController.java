package com.bdiaz89.litelibrary_api.web.controller;

import com.bdiaz89.litelibrary_api.domain.dto.book.BookRequestDTO;
import com.bdiaz89.litelibrary_api.domain.dto.book.BookResponseDTO;
import com.bdiaz89.litelibrary_api.service.entitie.BookService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

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

}
