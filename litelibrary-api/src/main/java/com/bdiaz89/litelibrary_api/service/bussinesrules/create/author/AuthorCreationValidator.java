package com.bdiaz89.litelibrary_api.service.bussinesrules.create.author;

import com.bdiaz89.litelibrary_api.domain.dto.author.AuthorRequestDTO;

public interface AuthorCreationValidator {
    void validate(AuthorRequestDTO request);
}
