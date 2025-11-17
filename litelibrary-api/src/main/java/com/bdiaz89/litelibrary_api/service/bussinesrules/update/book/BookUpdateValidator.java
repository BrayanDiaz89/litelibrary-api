package com.bdiaz89.litelibrary_api.service.bussinesrules.update.book;

import com.bdiaz89.litelibrary_api.domain.dto.book.BookUpdateRequestDTO;

public interface BookUpdateValidator {
    void validate(BookUpdateRequestDTO request);
}
