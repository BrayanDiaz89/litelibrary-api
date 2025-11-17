package com.bdiaz89.litelibrary_api.service.entitie.crud;

import com.bdiaz89.litelibrary_api.domain.dto.loan.BookLoanRequestDTO;
import com.bdiaz89.litelibrary_api.domain.dto.loan.BookLoanResponseDTO;
import com.bdiaz89.litelibrary_api.domain.entitie.*;
import com.bdiaz89.litelibrary_api.domain.exception.loan.RequestedBooksNotAvailable;
import com.bdiaz89.litelibrary_api.service.entitie.mapper.BookLoanMapper;
import com.bdiaz89.litelibrary_api.service.repository.AuthorRepository;
import com.bdiaz89.litelibrary_api.service.repository.BookLoanRepository;
import com.bdiaz89.litelibrary_api.service.repository.BookRepository;
import com.bdiaz89.litelibrary_api.service.repository.CustomerRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class CrudBookLoanRepository implements BookLoanRepository {

    private final BookLoanMapper mapper;
    private final BookRepository bookRepository;
    private final CustomerRepository customerRepository;
    private final AtomicLong idLoan = new AtomicLong(0);
    private final List<BookLoan> loans;

    public CrudBookLoanRepository(BookLoanMapper mapper, BookRepository bookRepository, CustomerRepository customerRepository) {
        this.mapper = mapper;
        this.bookRepository = bookRepository;
        this.customerRepository = customerRepository;
        this.loans = new ArrayList<>();
    }

    @Override
    public BookLoanResponseDTO create(BookLoanRequestDTO request) {

        Customer customer = customerRepository.findById(request.idCustomer());
        List<Book> booksInRepository = bookRepository.getBooksByListId(request.idBooks());

        List<Book> booksToLend = booksInRepository.stream()
                .filter(b-> b.getStatus().equals(StatusBook.AVAILABLE))
                .toList();
        if(booksToLend.isEmpty()){
            throw new RequestedBooksNotAvailable("Los libros están prestados actualmente. Valida su fecha de devolución en el repositorio.");
        }

        booksToLend.forEach(b-> b.setStatus(StatusBook.BORROWED));

        LocalDateTime dateAndTimeOfLoan = LocalDateTime.now();
        LocalDateTime bookReturnDate = dateAndTimeOfLoan.plusDays(2);

        BookLoan loanNew = mapper.toEntitie(request);
        loanNew.setIdLoan(idLoan.incrementAndGet());

        loanNew.setCustomer(customer);
        loanNew.setBooks(booksToLend);
        loanNew.setDateAndTimeOfLoan(dateAndTimeOfLoan);
        loanNew.setBookReturnDate(bookReturnDate);

        loans.add(loanNew);

        return mapper.toDto(loanNew);
    }


}
