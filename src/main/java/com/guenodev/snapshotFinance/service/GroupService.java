package com.guenodev.snapshotFinance.service;

import com.guenodev.snapshotFinance.dto.GroupDtoRegistration;
import com.guenodev.snapshotFinance.entity.Group;
import com.guenodev.snapshotFinance.enums.MessageRegistration;
import com.guenodev.snapshotFinance.repository.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GroupService {

    @Autowired
    private GroupRepository groupRepository;

    public MessageRegistration groupRegistration(GroupDtoRegistration groupDtoRegistration){

        Optional<GroupDtoRegistration> groupDtoRegistrationOptional = Optional.ofNullable(groupDtoRegistration);

        groupDtoRegistrationOptional.ifPresent(dtoRegistration -> groupRepository.save(new Group(null,groupDtoRegistration.getGroup_name())));

        return MessageRegistration.SUCCESSFUL_REGISTRATION;

    }







}
