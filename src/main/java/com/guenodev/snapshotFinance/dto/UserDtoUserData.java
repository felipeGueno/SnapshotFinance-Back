package com.guenodev.snapshotFinance.dto;

import com.guenodev.snapshotFinance.entity.Users;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

import java.util.UUID;

@Getter
public class UserDtoUserData {

    private UUID id;
    private String name;

    private String email;


    public UserDtoUserData(Users users) {
        this.name = users.getName();
        this.email = users.getEmail();
        this.id = users.getId();


    }
}
