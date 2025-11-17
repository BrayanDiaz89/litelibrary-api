package com.bdiaz89.litelibrary_api.service.bussinesrules.create.book;

import com.bdiaz89.litelibrary_api.domain.dto.book.BookRequestDTO;

public interface BookCreationValidator {
    void validate(BookRequestDTO request);
}
