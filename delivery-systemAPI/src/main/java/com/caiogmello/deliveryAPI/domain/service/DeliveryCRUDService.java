package com.caiogmello.deliveryAPI.domain.service;

import com.caiogmello.deliveryAPI.domain.exception.EnterpriseException;
import com.caiogmello.deliveryAPI.domain.model.Customer;
import com.caiogmello.deliveryAPI.domain.model.Delivery;
import com.caiogmello.deliveryAPI.domain.model.DeliveryStatus;
import com.caiogmello.deliveryAPI.domain.repository.CustomerRepository;
import com.caiogmello.deliveryAPI.domain.repository.DeliveryRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@AllArgsConstructor
@Service
public class DeliveryCRUDService {

    private DeliveryRepository deliveryRepository;
    private CustomerCRUDService customerCRUDService;

    @Transactional
    public Delivery request(Delivery delivery) {
        Customer customer = customerCRUDService.find(delivery.getCustomer().getId());

        delivery.setCustomer(customer);
        delivery.setStatus(DeliveryStatus.PENDING);
        delivery.setOrderDate(LocalDateTime.now());

        return deliveryRepository.save(delivery);
    }
}
