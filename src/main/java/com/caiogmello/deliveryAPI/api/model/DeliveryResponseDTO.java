package com.caiogmello.deliveryAPI.api.model;

import com.caiogmello.deliveryAPI.domain.model.DeliveryStatus;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Getter
@Setter
public class DeliveryResponseDTO {

    private Long id;
    private CustomerSummaryModel customer;
    private String customerName;
    private RecipientResponseDTO recipient;
    private BigDecimal fee;
    private DeliveryStatus status;
    private OffsetDateTime orderDate;
    private OffsetDateTime checkoutDate;
}
