package com.guenodev.snapshotFinance.controller;

import com.guenodev.snapshotFinance.dto.ExpenseGroupDtoDataReturn;
import com.guenodev.snapshotFinance.dto.ExpenseGroupDtoRegistration;
import com.guenodev.snapshotFinance.entity.ExpenseGroup;
import com.guenodev.snapshotFinance.enums.MessageRegistration;
import com.guenodev.snapshotFinance.service.GroupService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;
import java.util.List;

@RestController
@RequestMapping("/group")
public class ExpenseGroupController {

    @Autowired
    private GroupService groupService;

    @PostMapping("/{id}")
    public ResponseEntity<Object> expenseGroupRegistration(@RequestBody @Valid ExpenseGroupDtoRegistration expenseGroupDtoRegistration,
                                                           @PathVariable UUID id) {

        MessageRegistration messageRegistration = groupService.groupRegistration(expenseGroupDtoRegistration, id);

        return ResponseEntity.status(messageRegistration.getHttpStatus()).body(messageRegistration.getMessage());

    }

    @GetMapping
    public ResponseEntity<List<ExpenseGroupDtoDataReturn>> showAllExpenseGroups (){

        return ResponseEntity.status(HttpStatus.OK).body(groupService.getAllExpenseGroups());
    }

}
