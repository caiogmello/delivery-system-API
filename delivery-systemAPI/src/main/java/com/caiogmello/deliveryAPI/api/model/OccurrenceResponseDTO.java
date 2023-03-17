package com.caiogmello.deliveryAPI.api.model;

import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;

@Getter
@Setter
public class OccurrenceResponseDTO {

    private Long id;
    private String description;
    private OffsetDateTime registerDate;
}
