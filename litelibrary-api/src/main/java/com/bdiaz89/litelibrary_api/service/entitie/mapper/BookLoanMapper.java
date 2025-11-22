package com.bdiaz89.litelibrary_api.service.entitie.mapper;

import com.bdiaz89.litelibrary_api.domain.dto.loan.BookLoanPenaltyResponseDTO;
import com.bdiaz89.litelibrary_api.domain.dto.loan.BookLoanRequestDTO;
import com.bdiaz89.litelibrary_api.domain.dto.loan.BookLoanResponseDTO;
import com.bdiaz89.litelibrary_api.domain.entitie.BookLoan;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = {CustomerMapper.class, BookMapper.class })
public interface BookLoanMapper {

    BookLoanResponseDTO toDto(BookLoan bookLoan);

    @Mapping(target = "customer", ignore = true)
    @Mapping(target = "books", ignore = true)
    BookLoan toEntitie(BookLoanRequestDTO request);

    List<BookLoanPenaltyResponseDTO> toDto(List<BookLoan> loans);

    BookLoanPenaltyResponseDTO toDtoLoanPenalty(BookLoan loan);
}
