package com.bdiaz89.litelibrary_api.web.controller;

import com.bdiaz89.litelibrary_api.domain.dto.customer.CustomerRequestDTO;
import com.bdiaz89.litelibrary_api.domain.dto.customer.CustomerResponseDTO;
import com.bdiaz89.litelibrary_api.service.entitie.CustomerService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    private final CustomerService service;

    public CustomerController(CustomerService service) {
        this.service = service;
    }

    @PostMapping("/create")
    public ResponseEntity<CustomerResponseDTO> createCustomer(@RequestBody @Valid CustomerRequestDTO request,
                                                              UriComponentsBuilder uri){
        CustomerResponseDTO customerCreated = service.createCustomer(request);
        URI url = uri.path("/customer/{id}").buildAndExpand(customerCreated.idCustomer()).toUri();
        return ResponseEntity.created(url).body(customerCreated);
    }

}
