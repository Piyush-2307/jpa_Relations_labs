package com.peeyush.jpaRelations_labs.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CreateOrderRequest {

    @NotBlank
    private String name;

    @NotNull
    private int amount;
}
