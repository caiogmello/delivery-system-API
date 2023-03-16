package com.caiogmello.deliveryAPI.api.controller;

import com.caiogmello.deliveryAPI.Customer;
import com.caiogmello.deliveryAPI.domain.repository.CustomerRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@RestController
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;

    @GetMapping("/customers")
    public List<Customer> list(){
        return customerRepository.findAll();
    }

    @GetMapping("/customers/{customerId}")
    public Customer get(@PathVariable Long customerId){
        Optional<Customer> customer = customerRepository.findById(customerId);

        return customer.orElse(null);
    }
}
