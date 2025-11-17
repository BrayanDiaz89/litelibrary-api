package com.bdiaz89.litelibrary_api.service.entitie.mapper;

import com.bdiaz89.litelibrary_api.domain.dto.customer.CustomerRequestDTO;
import com.bdiaz89.litelibrary_api.domain.dto.customer.CustomerResponseDTO;
import com.bdiaz89.litelibrary_api.domain.dto.customer.CustomerUpdateDTO;
import com.bdiaz89.litelibrary_api.domain.entitie.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring", uses = {})
public interface CustomerMapper {

    CustomerResponseDTO toDto(Customer customer);

    Customer toEntitie(CustomerRequestDTO request);

    List<CustomerResponseDTO> toDto(List<Customer> customers);

    void updateCustomer(CustomerUpdateDTO request, @MappingTarget Customer customer);

}
