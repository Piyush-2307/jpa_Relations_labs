package com.peeyush.jpaRelations_labs.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class AddressResponse {
    private Long id;
    private String street;
    private String city;
}
