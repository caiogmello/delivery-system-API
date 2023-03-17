package com.caiogmello.deliveryAPI.api.model;

import com.fasterxml.jackson.annotation.JsonGetter;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RecipientResponseDTO {

    private String name;
    private String street;
    private String number;
    private String complement;
    private String hood;
}
