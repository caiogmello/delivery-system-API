package com.caiogmello.deliveryAPI.domain.repository;

import com.caiogmello.deliveryAPI.domain.model.Delivery;
import org.hibernate.metamodel.model.convert.spi.JpaAttributeConverter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeliveryRepository extends JpaRepository<Delivery, Long> {
}
