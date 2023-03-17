package com.caiogmello.deliveryAPI.domain.service;

import com.caiogmello.deliveryAPI.domain.exception.EnterpriseException;
import com.caiogmello.deliveryAPI.domain.model.Delivery;
import com.caiogmello.deliveryAPI.domain.model.Occurrence;
import com.caiogmello.deliveryAPI.domain.repository.DeliveryRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class RecordOccurrenceService {

    private GetDeliveryService getDeliveryService;
    @Transactional
    public Occurrence register(Long deliveryId, String description) {
        Delivery delivery = getDeliveryService.get(deliveryId);

        return delivery.addOccurrence(description);
    }
}
