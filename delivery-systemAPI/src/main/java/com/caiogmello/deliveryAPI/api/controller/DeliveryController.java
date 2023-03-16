package com.caiogmello.deliveryAPI.api.controller;

import com.caiogmello.deliveryAPI.domain.model.Delivery;
import com.caiogmello.deliveryAPI.domain.service.DeliveryCRUDService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/deliveries")
public class DeliveryController {

    private DeliveryCRUDService deliveryCRUDService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Delivery request(@RequestBody Delivery delivery) {
        return deliveryCRUDService.request(delivery);
    }
}
