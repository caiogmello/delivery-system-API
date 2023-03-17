package com.caiogmello.deliveryAPI.domain.service;


import com.caiogmello.deliveryAPI.domain.exception.EnterpriseException;
import com.caiogmello.deliveryAPI.domain.model.Delivery;
import com.caiogmello.deliveryAPI.domain.model.DeliveryStatus;
import com.caiogmello.deliveryAPI.domain.repository.DeliveryRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class CheckoutService {

    private DeliveryRepository deliveryRepository;
    private GetDeliveryService getDeliveryService;

    @Transactional
    public void checkout(Long deliveryId) {
        Delivery delivery = getDeliveryService.get(deliveryId);

        delivery.finalizeDelivery();

        deliveryRepository.save(delivery);

    }
}
