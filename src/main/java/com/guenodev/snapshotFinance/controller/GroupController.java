package com.guenodev.snapshotFinance.controller;

import com.guenodev.snapshotFinance.dto.GroupDtoRegistration;
import com.guenodev.snapshotFinance.dto.UserDtoRegistration;
import com.guenodev.snapshotFinance.enums.MessageRegistration;
import com.guenodev.snapshotFinance.service.GroupService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/group")
public class GroupController {

    @Autowired
    private GroupService groupService;

    @PostMapping
    public ResponseEntity<Object> userRegistration(@RequestBody @Valid GroupDtoRegistration groupDtoRegistration) {

        MessageRegistration messageRegistration = groupService.groupRegistration(groupDtoRegistration);

        return ResponseEntity.status(messageRegistration.getHttpStatus()).body(messageRegistration.getMessage());

    }
}
