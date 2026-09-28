package com.peeyush.jpaRelations_labs.dto;

import com.peeyush.jpaRelations_labs.enums.Activity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserResponse {
    private Long id;
    private String username;
    private String email;
    private Activity activity;
    private AddressResponse addressResponse;
}
