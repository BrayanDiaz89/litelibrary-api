package com.bdiaz89.litelibrary_api.service.bussinesrules.create.customer;

import com.bdiaz89.litelibrary_api.domain.dto.customer.CustomerRequestDTO;
import com.bdiaz89.litelibrary_api.domain.exception.customer.DocumentIdentityNotValidException;
import com.bdiaz89.litelibrary_api.service.repository.CustomerRepository;
import org.springframework.stereotype.Component;

@Component
public class ValidateIdentityContainsLetters implements CustomerCreationValidator {

    private final CustomerRepository repository;

    public ValidateIdentityContainsLetters(CustomerRepository repository) {
        this.repository = repository;
    }

    @Override
    public void validate(CustomerRequestDTO request) {
        var identityContainsLetter = repository.idDocumentContainsLetter(request.identityDocument());
        if (identityContainsLetter){
            throw new DocumentIdentityNotValidException("El documento de identidad suministrado no es válido, no se permiten letras.");
        }
    }
}
