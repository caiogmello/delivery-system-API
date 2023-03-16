package com.caiogmello.deliveryAPI.api.exceptionhandler;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.SecondaryTable;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
public class Problem {
    private Integer status;
    private LocalDateTime dateTime;
    private String title;
}
