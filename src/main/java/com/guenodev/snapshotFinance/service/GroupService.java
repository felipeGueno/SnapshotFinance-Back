package com.guenodev.snapshotFinance.service;

import com.guenodev.snapshotFinance.dto.ExpenseGroupDtoRegistration;
import com.guenodev.snapshotFinance.entity.ExpenseGroup;
import com.guenodev.snapshotFinance.entity.Users;
import com.guenodev.snapshotFinance.enums.MessageRegistration;
import com.guenodev.snapshotFinance.exceptions.RegistrationException;
import com.guenodev.snapshotFinance.repository.GroupRepository;
import com.guenodev.snapshotFinance.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import java.util.Optional;
import java.util.UUID;


@Service
public class GroupService {

    @Autowired
    private GroupRepository groupRepository;
    @Autowired
    private UserRepository userRepository;

    public MessageRegistration groupRegistration(ExpenseGroupDtoRegistration expenseGroupDtoRegistration, UUID id) {

        Users userAdm;
        String groupName;

        try {

            userAdm = findUser(id);

            groupName = getGroupName(expenseGroupDtoRegistration);


            existsGroupByUserAdm(userAdm, groupName);


        } catch (RegistrationException e) {
            return e.getMessageRegistration();
        }

        groupRepository.save(new ExpenseGroup(
                null,
                groupName,
                userAdm,
                addAdmToGroup(userAdm)));

        return MessageRegistration.SUCCESSFUL_REGISTRATION;

    }

    public void existsGroupByUserAdm(Users id, String groupName) throws RegistrationException {
        if (Optional.ofNullable(groupRepository.existsByGroupNameAndUserAdmin(id, groupName)).isPresent()) {
            throw new RegistrationException(MessageRegistration.GROUP_EXIST_TO_ADM);
        }
    }

    private String getGroupName(ExpenseGroupDtoRegistration expenseGroupDtoRegistration) throws RegistrationException {
        return Optional.ofNullable(expenseGroupDtoRegistration.getGroup_name())
                .orElseThrow(() -> new RegistrationException(MessageRegistration.GROUP_NAME_MISSING));

    }

    private Users findUser(UUID id) throws RegistrationException {
        return Optional.ofNullable(id)
                .map(userId -> userRepository.findById(userId))
                .orElseThrow(() -> new RegistrationException(MessageRegistration.USER_NOT_FOUND));

    }


    private List<Users> addAdmToGroup(Users userAdm) {
        List<Users> usersList = new ArrayList<>();
        usersList.add(userAdm);
        return usersList;
    }


}
