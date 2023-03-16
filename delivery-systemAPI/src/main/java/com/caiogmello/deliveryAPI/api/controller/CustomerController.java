package com.caiogmello.deliveryAPI.api.controller;

import com.caiogmello.deliveryAPI.Customer;
import com.caiogmello.deliveryAPI.domain.repository.CustomerRepository;
import com.caiogmello.deliveryAPI.domain.service.CustomerCRUDService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;
    private CustomerCRUDService customerCRUDService;

    @GetMapping
    public List<Customer> list(){
        return customerRepository.findAll();
    }

    @GetMapping("/{customerId}")
    public ResponseEntity<Customer> get(@PathVariable Long customerId){
        Optional<Customer> customer = customerRepository.findById(customerId);

        return customer.map(ResponseEntity::ok).
                orElseGet(() -> ResponseEntity.notFound().build());

    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Customer add(@Valid @RequestBody Customer customer) {
        return customerCRUDService.save(customer);
    }

    @PutMapping("/{customerId}")
    public ResponseEntity<Customer> refresh(@PathVariable Long customerId,
                                           @Valid @RequestBody Customer customer) {
        if (!customerRepository.existsById(customerId)) {
            return ResponseEntity.notFound().build();
        }

        customer.setId(customerId);
        customer = customerCRUDService.save(customer);

        return ResponseEntity.ok(customer);
    }

    @DeleteMapping("/{customerId}")
    public ResponseEntity<Void> remove(@PathVariable Long customerId) {
        if (!customerRepository.existsById(customerId)) {
            return ResponseEntity.notFound().build();
        }

        customerCRUDService.delete(customerId);

        return ResponseEntity.noContent().build();
    }
}
