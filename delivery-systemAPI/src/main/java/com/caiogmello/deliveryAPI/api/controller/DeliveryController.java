package com.caiogmello.deliveryAPI.api.controller;

import com.caiogmello.deliveryAPI.api.assembler.DeliveryAssembler;
import com.caiogmello.deliveryAPI.api.model.DeliveryResponseDTO;
import com.caiogmello.deliveryAPI.api.model.RecipientResponseDTO;
import com.caiogmello.deliveryAPI.api.model.input.DeliveryInput;
import com.caiogmello.deliveryAPI.domain.model.Customer;
import com.caiogmello.deliveryAPI.domain.model.Delivery;
import com.caiogmello.deliveryAPI.domain.repository.DeliveryRepository;
import com.caiogmello.deliveryAPI.domain.service.DeliveryCRUDService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
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
    private DeliveryAssembler deliveryAssembler;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public DeliveryResponseDTO request(@Valid @RequestBody DeliveryInput deliveryInput) {
        Delivery delivery = deliveryAssembler.toEntity(deliveryInput);
        return deliveryAssembler.toModel(deliveryCRUDService.request(delivery));
    }

    @GetMapping
    public List<DeliveryResponseDTO> list() {
        return deliveryAssembler.toCollectionModel(deliveryRepository.findAll());
    }

    @GetMapping("/{deliveryId}")
    public ResponseEntity<DeliveryResponseDTO> find(@PathVariable Long deliveryId) {
        return deliveryRepository.findById(deliveryId)
                .map(delivery -> ResponseEntity.ok(deliveryAssembler.toModel(delivery)))
                .orElse(ResponseEntity.notFound().build());
    }
}
