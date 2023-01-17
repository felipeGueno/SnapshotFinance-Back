package com.guenodev.snapshotFinance.dto;

import com.guenodev.snapshotFinance.entity.Users;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class UserDtoUserData {

    @NotBlank
    private String name;
    @NotBlank
    private String email;


    public UserDtoUserData(Users users) {
        this.name = users.getName();
        this.email = users.getEmail();


    }
}
