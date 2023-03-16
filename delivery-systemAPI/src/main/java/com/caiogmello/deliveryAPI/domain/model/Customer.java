package com.caiogmello.deliveryAPI.domain.model;

import com.caiogmello.deliveryAPI.domain.ValidationGroups;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import jakarta.validation.groups.Default;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Getter
@Setter
@Entity
public class Customer {
    @NotNull(groups = ValidationGroups.CustomerId.class)
    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(max = 60)
    private String name;

    @NotBlank
    @Email
    @Size(max = 255)
    private String email;

    @NotBlank
    @Size(max = 20)
    private String phone;
}
