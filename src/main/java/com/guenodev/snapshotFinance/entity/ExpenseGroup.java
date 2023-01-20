package com.guenodev.snapshotFinance.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.ArrayList;
import java.util.UUID;
import java.util.List;


@Getter
@Builder(toBuilder = true)
@Entity
public class ExpenseGroup {
    @Id
    @GeneratedValue
    private UUID id;
    @NotNull
    private String group_name;

    @NotNull
    @ManyToOne
    private Users userAdm;

    @ManyToMany
    private List<Users> users;

    public ExpenseGroup(UUID id, String group_name, Users userAdm,  List<Users> users) {
        this.id = id;
        this.group_name = group_name;
        this.userAdm = userAdm;
        this.users = users;

    }

    public ExpenseGroup() {
    }
}
