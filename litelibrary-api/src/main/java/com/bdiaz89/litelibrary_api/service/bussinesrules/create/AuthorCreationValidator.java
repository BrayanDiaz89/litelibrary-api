package com.bdiaz89.litelibrary_api.service.bussinesrules.create;

import com.bdiaz89.litelibrary_api.domain.dto.AuthorRequestDTO;

public interface AuthorCreationValidator {
    void validate(AuthorRequestDTO request);
}
