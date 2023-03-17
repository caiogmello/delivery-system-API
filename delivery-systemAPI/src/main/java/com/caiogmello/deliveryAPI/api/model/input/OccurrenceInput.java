package com.caiogmello.deliveryAPI.api.model.input;

import jakarta.persistence.SecondaryTable;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OccurrenceInput {
    @NotBlank
    private String description;
}
