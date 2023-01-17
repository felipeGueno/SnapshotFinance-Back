package com.guenodev.snapshotFinance.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder(toBuilder = true)
@Entity
public class UserGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "group_id")
    @NotNull
    private Group group;
    @ManyToOne
    @JoinColumn(name = "user_id")
    @NotNull
    private Users users;
    @NotNull
    private boolean user_adm;


    public UserGroup(Integer id, Group group, Users users, boolean user_adm) {
        this.id = id;
        this.group = group;
        this.users = users;
        this.user_adm = user_adm;
    }

    public UserGroup() {

    }
}
