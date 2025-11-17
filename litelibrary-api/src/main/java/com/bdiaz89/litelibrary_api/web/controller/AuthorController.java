package com.bdiaz89.litelibrary_api.web.controller;

import com.bdiaz89.litelibrary_api.domain.dto.author.AuthorRequestDTO;
import com.bdiaz89.litelibrary_api.domain.dto.author.AuthorResponseDTO;
import com.bdiaz89.litelibrary_api.domain.dto.author.AuthorUpdateDateOfDeathDTO;
import com.bdiaz89.litelibrary_api.domain.dto.author.AuthorWithListBooksDTO;
import com.bdiaz89.litelibrary_api.service.entitie.AuthorService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/author")
public class AuthorController {

    private final AuthorService service;

    public AuthorController(AuthorService service) {
        this.service = service;
    }

    @PostMapping("/create")
    public ResponseEntity<AuthorResponseDTO> createAuthor(@RequestBody @Valid AuthorRequestDTO request,
                                                          UriComponentsBuilder uri){
        AuthorResponseDTO authorCreated = service.createAuthor(request);
        URI url = uri.path("/author/{id}").buildAndExpand(authorCreated.idAuthor()).toUri();
        return ResponseEntity.created(url).body(authorCreated);
    }

    @GetMapping("/all")
    public ResponseEntity<List<AuthorResponseDTO>> getListOfAuthors(){
        return ResponseEntity.ok().body(service.getListOfAuthors());
    }

    @GetMapping("/with/books")
    public ResponseEntity<List<AuthorWithListBooksDTO>> getListAuthorsWithBooks(){
        return ResponseEntity.ok().body(service.getListAuthorsWithBooks());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AuthorResponseDTO> getAuthorById(@PathVariable Long id){
        return ResponseEntity.ok().body(service.getAuthorById(id));
    }

    @GetMapping("/with/books/{id}")
    public ResponseEntity<AuthorWithListBooksDTO> getAuthorWithBooksByIdById(@PathVariable Long id){
        return ResponseEntity.ok().body(service.getAuthorWithBooksById(id));
    }

    @GetMapping("/search")
    public ResponseEntity<List<AuthorWithListBooksDTO>> getAllAuthorsByNameOrLastnameOrBirthDateOrDeathDate(
            @RequestParam(value = "name", required = false) String name,
            @RequestParam(value = "lastname", required = false) String lastname,
            @RequestParam(value = "birthYear", required = false) Integer birthYear,
            @RequestParam(value = "deathYear", required = false) Integer deathYear
    ){
        List<AuthorWithListBooksDTO> result = service.getAllAuthorsByNameOrLastnameOrBirthDateOrDeathDate(name, lastname, birthYear, deathYear);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/search/birthyear")
    public ResponseEntity<List<AuthorWithListBooksDTO>> getAllAuthorsBetweenBirthYear(
            @RequestParam(value = "startBirthyear") Integer startBirthyear,
            @RequestParam(value = "endBirthyear") Integer endBirthyear
    ){
        List<AuthorWithListBooksDTO> result = service.getAllAuthorsBetweenBirthYear(startBirthyear, endBirthyear);
        return ResponseEntity.ok(result);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AuthorResponseDTO> updateAuthor(@PathVariable Long id, @RequestBody @Valid AuthorRequestDTO request){
        return ResponseEntity.ok(service.updateAuthor(id, request));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<AuthorResponseDTO> updateFieldDateOfDeath(@PathVariable Long id,
                                                                    @RequestBody @Valid AuthorUpdateDateOfDeathDTO request){
        return ResponseEntity.ok(service.updateFieldDateOfDeath(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.deleteAuthor(id);
        return ResponseEntity.noContent().build();
    }
}


