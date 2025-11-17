package com.bdiaz89.litelibrary_api.service.entitie.crud;

import com.bdiaz89.litelibrary_api.domain.dto.customer.CustomerRequestDTO;
import com.bdiaz89.litelibrary_api.domain.dto.customer.CustomerResponseDTO;
import com.bdiaz89.litelibrary_api.domain.dto.customer.CustomerUpdateDTO;
import com.bdiaz89.litelibrary_api.domain.entitie.Customer;
import com.bdiaz89.litelibrary_api.domain.exception.customer.CustomerDoesNotExistsException;
import com.bdiaz89.litelibrary_api.service.entitie.mapper.CustomerMapper;
import com.bdiaz89.litelibrary_api.service.repository.CustomerRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class CrudCustomerRepository implements CustomerRepository {

    private final CustomerMapper mapper;
    private final List<Customer> customers;
    private final AtomicLong idCustomer = new AtomicLong(0);


    public CrudCustomerRepository(CustomerMapper mapper) {
        this.mapper = mapper;
        this.customers = new ArrayList<>();
    }

    @Override
    public CustomerResponseDTO create(CustomerRequestDTO request) {
        Customer customer = mapper.toEntitie(request);
        customer.setIdCustomer(idCustomer.incrementAndGet());
        customers.add(customer);
        return mapper.toDto(customer);
    }

    @Override
    public boolean existsByIdDocument(String idDocument) {
        return customers.stream()
                .anyMatch(c -> c.getIdentityDocument().equalsIgnoreCase(idDocument));
    }

    @Override
    public boolean idDocumentContainsLetter(String idDocument) {
        return customers.stream()
                .anyMatch(c-> c.getIdentityDocument().matches("[a-zA-Z]+"));
    }

    @Override
    public List<CustomerResponseDTO> findAll() {
        return mapper.toDto(customers);
    }

    @Override
    public Customer findById(Long id) {
        return customers.stream()
                .filter(c-> c.getIdCustomer().equals(id))
                .findAny()
                .orElseThrow(()-> new CustomerDoesNotExistsException("No existe un cliente con el id consultado."));
    }

    @Override
    public CustomerResponseDTO findByIdResponse(Long id) {
        return customers.stream()
                .filter(c-> c.getIdCustomer().equals(id))
                .findAny()
                .map(mapper::toDto)
                .orElseThrow(()-> new CustomerDoesNotExistsException("No existe un cliente con el id consultado."));
    }

    @Override
    public CustomerResponseDTO update(Long id, CustomerUpdateDTO request) {
        Customer customer = findById(id);
        mapper.updateCustomer(request, customer);
        return mapper.toDto(customer);
    }

    @Override
    public void delete(Long id) {
        Customer customer = findById(id);
        customers.remove(customer);
    }
}
