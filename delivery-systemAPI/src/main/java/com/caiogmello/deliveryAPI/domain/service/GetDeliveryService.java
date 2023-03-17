package com.caiogmello.deliveryAPI.domain.service;

import com.caiogmello.deliveryAPI.domain.exception.EnterpriseException;
import com.caiogmello.deliveryAPI.domain.exception.EntityNotFoundException;
import com.caiogmello.deliveryAPI.domain.model.Delivery;
import com.caiogmello.deliveryAPI.domain.repository.DeliveryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class GetDeliveryService {

    private DeliveryRepository deliveryRepository;

    public Delivery get(Long deliveryId) {
        return deliveryRepository.findById(deliveryId)
                .orElseThrow(() -> new EntityNotFoundException("Delivery not found"));
    }
}
