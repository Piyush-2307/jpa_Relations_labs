package com.peeyush.jpaRelations_labs.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UpdateRequest {
    @NotNull
    private String username;

    @NotNull
    @Email
    private String email;


}
