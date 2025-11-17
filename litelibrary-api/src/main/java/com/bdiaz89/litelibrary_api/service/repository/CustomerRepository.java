package com.bdiaz89.litelibrary_api.service.repository;

import com.bdiaz89.litelibrary_api.domain.dto.customer.CustomerRequestDTO;
import com.bdiaz89.litelibrary_api.domain.dto.customer.CustomerResponseDTO;

public interface CustomerRepository {

    CustomerResponseDTO create(CustomerRequestDTO request);

    boolean existsByIdDocument(String idDocument);

    boolean idDocumentContainsLetter(String idDocument);
}
