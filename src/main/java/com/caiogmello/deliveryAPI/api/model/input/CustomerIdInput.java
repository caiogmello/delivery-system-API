package com.caiogmello.deliveryAPI.api.model.input;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerIdInput {
    @NotNull
    private Long id;
}
