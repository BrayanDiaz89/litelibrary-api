package com.bdiaz89.litelibrary_api.service.bussinesrules.patch;

import com.bdiaz89.litelibrary_api.domain.dto.author.AuthorUpdateDateOfDeathDTO;

public interface AuthorPatchValidator {

    void validate(Long id, AuthorUpdateDateOfDeathDTO request);

}
