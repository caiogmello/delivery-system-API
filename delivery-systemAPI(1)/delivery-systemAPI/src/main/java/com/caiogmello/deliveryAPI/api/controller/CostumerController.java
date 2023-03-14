package com.caiogmello.deliveryAPI.api.controller;

import com.caiogmello.deliveryAPI.Costumer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class CostumerController {
    @GetMapping("/clients")
    public List<Costumer> list(){
        Costumer costumer1 = new Costumer();
        costumer1.setId(1L);
        costumer1.setName("Caio");
        costumer1.setPhone("77 998564445");
        costumer1.setEmail("caiogomedemello@gmail.com");

        Costumer costumer2 = new Costumer();
        costumer2.setId(2L);
        costumer2.setName("João");
        costumer2.setPhone("77 928313911");
        costumer2.setEmail("joaocmwh@gmail.com");

        return Arrays.asList(costumer1, costumer2);
    }
}
