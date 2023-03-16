package com.caiogmello.deliveryAPI.api.exceptionhandler;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.SecondaryTable;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
public class Problem {
    private Integer status;
    private OffsetDateTime dateTime;
    private String title;
}
