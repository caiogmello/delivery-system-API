package com.caiogmello.deliveryAPI.api.controller;

import com.caiogmello.deliveryAPI.domain.model.Customer;
import com.caiogmello.deliveryAPI.domain.model.Delivery;
import com.caiogmello.deliveryAPI.domain.repository.DeliveryRepository;
import com.caiogmello.deliveryAPI.domain.service.DeliveryCRUDService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/deliveries")
public class DeliveryController {

    private DeliveryRepository deliveryRepository;
    private DeliveryCRUDService deliveryCRUDService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Delivery request(@Valid @RequestBody Delivery delivery) {
        return deliveryCRUDService.request(delivery);
    }

    @GetMapping
    public List<Delivery> list() {
        return deliveryRepository.findAll();
    }

    @GetMapping("/{deliveryId}")
    public ResponseEntity<Delivery> find(@PathVariable Long deliveryId) {
        return deliveryRepository.findById(deliveryId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
