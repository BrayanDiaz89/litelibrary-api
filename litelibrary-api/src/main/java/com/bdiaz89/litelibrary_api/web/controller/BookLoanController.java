package com.bdiaz89.litelibrary_api.web.controller;

import com.bdiaz89.litelibrary_api.domain.dto.loan.BookLoanRequestDTO;
import com.bdiaz89.litelibrary_api.domain.dto.loan.BookLoanResponseDTO;
import com.bdiaz89.litelibrary_api.service.entitie.BookLoanService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/book/loan")
public class BookLoanController {

    private final BookLoanService service;

    public BookLoanController(BookLoanService service) {
        this.service = service;
    }

    @PostMapping("/create")
    public ResponseEntity<BookLoanResponseDTO> createLoan(@RequestBody @Valid BookLoanRequestDTO request,
                                                          UriComponentsBuilder uri){
        BookLoanResponseDTO loanCreated = service.createLoan(request);
        URI url = uri.path("/book/loan/{id}").buildAndExpand(loanCreated.idLoan()).toUri();
        return ResponseEntity.created(url).body(loanCreated);
    }
}
