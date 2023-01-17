package com.guenodev.snapshotFinance.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder(toBuilder = true)
@Entity
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull
    private String group_name;

    public Group(Integer id, String group_name) {
        this.id = id;
        this.group_name = group_name;
    }

    public Group() {
    }
}
