package com.bdiaz89.litelibrary_api.web.controller;

import com.bdiaz89.litelibrary_api.domain.dto.loan.BookLoanPenaltyResponseDTO;
import com.bdiaz89.litelibrary_api.domain.dto.loan.BookLoanRequestDTO;
import com.bdiaz89.litelibrary_api.domain.dto.loan.BookLoanResponseDTO;
import com.bdiaz89.litelibrary_api.service.entitie.BookLoanService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

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

    @GetMapping("/all")
    public ResponseEntity<List<BookLoanPenaltyResponseDTO>> getAllLoans(){
        return ResponseEntity.ok(service.getAllLoans());
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookLoanPenaltyResponseDTO> getLoanById(@PathVariable Long id){
        return ResponseEntity.ok(service.getLoanById(id));
    }
}
