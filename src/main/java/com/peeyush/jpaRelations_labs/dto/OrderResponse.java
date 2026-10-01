package com.peeyush.jpaRelations_labs.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class OrderResponse {
    private Long id;
    private String name;
    private int amount;
}
