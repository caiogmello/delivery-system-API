package com.caiogmello.deliveryAPI.api.controller;

import com.caiogmello.deliveryAPI.Customer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class CustomerController {
    @GetMapping("/clients")
    public List<Customer> list(){
        Customer customer1 = new Customer();
        customer1.setId(1L);
        customer1.setName("Caio");
        customer1.setPhone("77 998564445");
        customer1.setEmail("caiogomedemello@gmail.com");

        Customer customer2 = new Customer();
        customer2.setId(2L);
        customer2.setName("João");
        customer2.setPhone("77 928313911");
        customer2.setEmail("joaocmwh@gmail.com");

        return Arrays.asList(customer1, customer2);
    }
}
