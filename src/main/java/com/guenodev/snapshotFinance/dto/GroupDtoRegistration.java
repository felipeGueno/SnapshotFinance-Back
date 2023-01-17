package com.guenodev.snapshotFinance.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class GroupDtoRegistration {

    @NotBlank
    private String group_name;

    public GroupDtoRegistration(String group_name) {
        this.group_name = group_name;
    }
}
