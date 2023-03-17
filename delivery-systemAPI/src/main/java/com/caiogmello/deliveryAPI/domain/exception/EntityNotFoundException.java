package com.caiogmello.deliveryAPI.domain.exception;

import lombok.Setter;

import java.io.Serial;

public class EntityNotFoundException extends EnterpriseException {
    @Serial
    private static final long serialVersionUID = 1L;

    public EntityNotFoundException(String message){
        super(message);
    }
}
