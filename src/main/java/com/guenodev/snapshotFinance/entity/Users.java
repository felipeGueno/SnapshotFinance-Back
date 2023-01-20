package com.guenodev.snapshotFinance.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;


import java.util.UUID;
@AllArgsConstructor
@Getter
@Builder(toBuilder = true)
@Entity
public class Users {
    @Id
    @GeneratedValue
    private UUID id;
    @NotNull
    private String name;
    @NotNull
    private String email;
    @NotNull
    private String senha;

    public Users() {

    }
}
