package com.bdiaz89.litelibrary_api.service.bussinesrules.create.customer;

import com.bdiaz89.litelibrary_api.domain.dto.customer.CustomerRequestDTO;

public interface CustomerCreationValidator {
    void validate(CustomerRequestDTO request);
}
