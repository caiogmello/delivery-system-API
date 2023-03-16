package com.caiogmello.deliveryAPI.domain.model;

import com.caiogmello.deliveryAPI.domain.ValidationGroups;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.groups.ConvertGroup;
import jakarta.validation.groups.Default;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Delivery {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ConvertGroup(from = Default.class, to = ValidationGroups.CustomerId.class)
    @ManyToOne
    private Customer customer;
    @Embedded
    private Recipient recipient;
    private BigDecimal fee;
    @Enumerated(EnumType.STRING)
    private DeliveryStatus status;

    private OffsetDateTime orderDate;

    private OffsetDateTime checkoutDate;

}
