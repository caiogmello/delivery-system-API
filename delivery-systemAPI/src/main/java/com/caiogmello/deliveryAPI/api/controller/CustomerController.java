package com.caiogmello.deliveryAPI.api.controller;

import com.caiogmello.deliveryAPI.Customer;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class CustomerController {
    @PersistenceContext
    private EntityManager manager;

    @GetMapping("/customers")
    public List<Customer> list(){
        return manager.createQuery("from Customer", Customer.class)
                .getResultList();
    }
}
