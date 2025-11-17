package com.bdiaz89.litelibrary_api.service.entitie;

import com.bdiaz89.litelibrary_api.domain.dto.customer.CustomerRequestDTO;
import com.bdiaz89.litelibrary_api.domain.dto.customer.CustomerResponseDTO;
import com.bdiaz89.litelibrary_api.service.bussinesrules.create.customer.CustomerCreationValidator;
import com.bdiaz89.litelibrary_api.service.repository.CustomerRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    private final CustomerRepository repository;
    private final List<CustomerCreationValidator> creationValidators;

    public CustomerService(CustomerRepository repository, List<CustomerCreationValidator> creationValidators) {
        this.repository = repository;
        this.creationValidators = creationValidators;
    }

    public CustomerResponseDTO createCustomer(CustomerRequestDTO request) {
        creationValidators.forEach(v-> v.validate(request));
        return repository.create(request);
    }
}
