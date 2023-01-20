package com.guenodev.snapshotFinance.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class ExpenseGroupDtoRegistration {


    @NotBlank
    private String group_name;

    public ExpenseGroupDtoRegistration(String group_name) {
        this.group_name = group_name;
    }

    public ExpenseGroupDtoRegistration() {
    }
}
