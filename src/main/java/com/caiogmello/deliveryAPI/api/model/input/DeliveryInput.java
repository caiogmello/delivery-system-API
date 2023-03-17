package com.caiogmello.deliveryAPI.api.model.input;

import com.caiogmello.deliveryAPI.domain.model.Recipient;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Getter
@Setter
public class DeliveryInput {
    @Valid
    @NotNull
    private CustomerIdInput customer;

    @Valid
    @NotNull
    private RecipientInput recipient;

    @NotNull
    private BigDecimal fee;
}
