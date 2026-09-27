package com.peeyush.jpaRelations_labs.dto;

import com.peeyush.jpaRelations_labs.entity.Address;
import com.peeyush.jpaRelations_labs.enums.Activity;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CreateUserRequest {
    @NotNull
    private String username;

    @NotNull
    @Email
    private String email;

    @NotNull
    private String password;

    private Activity activity;

    private String street;

    private String city;
}
