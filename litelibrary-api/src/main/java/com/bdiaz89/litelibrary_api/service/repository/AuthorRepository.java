package com.bdiaz89.litelibrary_api.service.repository;

import com.bdiaz89.litelibrary_api.domain.dto.AuthorRequestDTO;
import com.bdiaz89.litelibrary_api.domain.dto.AuthorResponseDTO;


public interface AuthorRepository {

    AuthorResponseDTO createAuthor(AuthorRequestDTO request);

}
