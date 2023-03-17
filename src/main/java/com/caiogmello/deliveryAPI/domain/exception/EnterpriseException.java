package com.caiogmello.deliveryAPI.domain.exception;

import java.io.Serial;

public class EnterpriseException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 1L;

    public EnterpriseException(String message) {
        super(message);
    }
}
