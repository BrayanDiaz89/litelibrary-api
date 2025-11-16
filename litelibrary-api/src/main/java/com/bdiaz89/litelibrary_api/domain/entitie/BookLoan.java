package com.bdiaz89.litelibrary_api.domain.entitie;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class BookLoan {

    private Customer customer;
    private List<Book> books;
    private LocalDateTime dateAndTimeOfLoan;
    private LocalDate bookReturnDate;

    private BigDecimal penaltyAmount;
    private Boolean penaltyPaid;

}
