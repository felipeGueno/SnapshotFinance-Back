package com.guenodev.snapshotFinance.dto;

import jakarta.validation.constraints.NotBlank;

import lombok.Getter;

@Getter
public class UserDtoRegistration {

    @NotBlank
    private final String name;
    @NotBlank
    private final String email;
    @NotBlank
    private final String senha;


    public UserDtoRegistration(String name, String email, String senha) {
        this.name = name;
        this.email = email;
        this.senha = senha;

    }
}
