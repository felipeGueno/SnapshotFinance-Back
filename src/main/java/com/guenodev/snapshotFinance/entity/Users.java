package com.guenodev.snapshotFinance.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Builder(toBuilder = true)
@Entity
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull
    private String name;
    @NotNull
    private String email;
    @NotNull
    private String senha;
    @NotNull
    private boolean em_grupo;

    public Users(Integer id, String name, String email, String senha, boolean em_grupo) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.senha = senha;
        this.em_grupo = em_grupo;
    }

    public Users() {

    }
}
