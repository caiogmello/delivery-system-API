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

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Delivery {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Valid
    @ConvertGroup(from = Default.class, to = ValidationGroups.CustomerId.class)
    @NotNull
    @ManyToOne
    private Customer customer;
    @NotNull
    @Valid
    @Embedded
    private Recipient recipient;
    @NotNull
    private BigDecimal fee;
    @Enumerated(EnumType.STRING)

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private DeliveryStatus status;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private LocalDateTime orderDate;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private LocalDateTime checkoutDate;

}
