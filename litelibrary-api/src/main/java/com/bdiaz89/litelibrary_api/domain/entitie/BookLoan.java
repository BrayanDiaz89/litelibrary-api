package com.bdiaz89.litelibrary_api.domain.entitie;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BookLoan {

    private Long idLoan;
    private Customer customer;
    private List<Book> books;
    private LocalDateTime dateAndTimeOfLoan;
    private LocalDateTime bookReturnDate;

    private Boolean penaltyPaid;
    private BigDecimal penaltyAmount;


}
