package com.bdiaz89.litelibrary_api.web.controller;

import com.bdiaz89.litelibrary_api.domain.dto.customer.CustomerRequestDTO;
import com.bdiaz89.litelibrary_api.domain.dto.customer.CustomerResponseDTO;
import com.bdiaz89.litelibrary_api.domain.dto.customer.CustomerUpdateDTO;
import com.bdiaz89.litelibrary_api.service.entitie.CustomerService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

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

    @GetMapping("/all")
    public ResponseEntity<List<CustomerResponseDTO>> getAllCustomers(){
        return ResponseEntity.ok(service.getAllCustomers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerResponseDTO> getCustomerById(@PathVariable Long id){
        return ResponseEntity.ok(service.getCustomerById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CustomerResponseDTO> updateCustomer(@PathVariable Long id, @RequestBody @Valid CustomerUpdateDTO request){
        return ResponseEntity.ok(service.updateCustomer(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable Long id){
        service.deleteCustomer(id);
        return ResponseEntity.noContent().build();
    }
}
