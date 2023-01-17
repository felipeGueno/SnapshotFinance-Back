package com.guenodev.snapshotFinance.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class UserDtoUserData {

    @NotBlank
    private String name;
    @NotBlank
    private String email;




    public UserDtoUserData(String name, String email) {
        this.name = name;
        this.email = email;


    }
}
