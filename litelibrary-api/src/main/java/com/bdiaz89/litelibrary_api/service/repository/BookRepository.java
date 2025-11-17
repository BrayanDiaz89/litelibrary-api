package com.bdiaz89.litelibrary_api.service.repository;

import com.bdiaz89.litelibrary_api.domain.dto.book.BookRequestDTO;
import com.bdiaz89.litelibrary_api.domain.dto.book.BookResponseDTO;

public interface BookRepository {
    BookResponseDTO create(BookRequestDTO request);

    boolean existsByTitle(BookRequestDTO request);

    boolean existsByISBN(BookRequestDTO request);
}
