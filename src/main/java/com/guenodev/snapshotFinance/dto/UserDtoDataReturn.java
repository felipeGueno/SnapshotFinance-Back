package com.guenodev.snapshotFinance.dto;

import com.guenodev.snapshotFinance.entity.Users;

import lombok.Getter;

import java.util.UUID;

@Getter
public class UserDtoDataReturn {

    private UUID id;
    private String name;

    private String email;


    public UserDtoDataReturn(Users users) {
        this.name = users.getName();
        this.email = users.getEmail();
        this.id = users.getId();


    }
}
