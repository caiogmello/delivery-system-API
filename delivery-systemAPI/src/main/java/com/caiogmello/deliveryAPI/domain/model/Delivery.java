package com.caiogmello.deliveryAPI.domain.model;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Delivery {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Customer customer;
    @Embedded
    private Recipient recipient;
    private BigDecimal fee;
    @Enumerated(EnumType.STRING)
    private DeliveryStatus status;
    private LocalDateTime orderDate;
    private LocalDateTime checkoutDate;

}
