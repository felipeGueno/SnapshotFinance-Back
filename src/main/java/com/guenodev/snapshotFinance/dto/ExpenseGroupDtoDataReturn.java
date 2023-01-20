package com.guenodev.snapshotFinance.dto;

import com.guenodev.snapshotFinance.entity.Users;
import java.util.ArrayList;
import java.util.List;


public class ExpenseGroupDtoDataReturn {

    private String group_name;

    private String userAdm;

    private List<Users> users;

    public ExpenseGroupDtoDataReturn(String group_name, String userAdm, List<Users> users) {
        this.group_name = group_name;
        this.userAdm = userAdm;
        this.users = users;
    }

    public String getGroup_name() {
        return group_name;
    }

    public String getUserAdm() {
        return userAdm;
    }

    public List<String> getUsers() {
        List<String> usersNameGroup = new ArrayList<>();
        this.users.forEach(users1 -> usersNameGroup.add(users1.getName()));
        return usersNameGroup;
    }
}
