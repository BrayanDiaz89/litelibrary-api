package com.bdiaz89.litelibrary_api.service.repository;

import com.bdiaz89.litelibrary_api.domain.dto.customer.CustomerRequestDTO;
import com.bdiaz89.litelibrary_api.domain.dto.customer.CustomerResponseDTO;
import com.bdiaz89.litelibrary_api.domain.dto.customer.CustomerUpdateDTO;
import com.bdiaz89.litelibrary_api.domain.entitie.Customer;

import java.util.List;

public interface CustomerRepository {

    CustomerResponseDTO create(CustomerRequestDTO request);

    boolean existsByIdDocument(String idDocument);

    boolean idDocumentContainsLetter(String idDocument);

    List<CustomerResponseDTO> findAll();
    
    Customer findById(Long id);

    CustomerResponseDTO findByIdResponse(Long id);

    CustomerResponseDTO update(Long id, CustomerUpdateDTO request);

    void delete(Long id);
}
