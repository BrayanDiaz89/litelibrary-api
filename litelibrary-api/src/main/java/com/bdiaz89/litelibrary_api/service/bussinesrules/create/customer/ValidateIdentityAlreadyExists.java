package com.bdiaz89.litelibrary_api.service.bussinesrules.create.customer;

import com.bdiaz89.litelibrary_api.domain.dto.customer.CustomerRequestDTO;
import com.bdiaz89.litelibrary_api.domain.exception.customer.CustomerAlreadyExistsException;
import com.bdiaz89.litelibrary_api.service.repository.CustomerRepository;
import org.springframework.stereotype.Component;

@Component
public class ValidateIdentityAlreadyExists implements CustomerCreationValidator{

    private final CustomerRepository repository;

    public ValidateIdentityAlreadyExists(CustomerRepository repository) {
        this.repository = repository;
    }

    @Override
    public void validate(CustomerRequestDTO request) {
        var existsById = repository.existsByIdDocument(request.identityDocument());
        if(existsById){
            throw new CustomerAlreadyExistsException("Ya existe un cliente con el documento de identidad especificado.");
        }
    }
}
