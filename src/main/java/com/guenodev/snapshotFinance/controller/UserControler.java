package com.guenodev.snapshotFinance.controller;

import com.guenodev.snapshotFinance.dto.UserDtoRegistration;
import com.guenodev.snapshotFinance.dto.UserDtoDataReturn;
import com.guenodev.snapshotFinance.enums.MessageRegistration;
import com.guenodev.snapshotFinance.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;


@RestController
@RequestMapping("/users")
public class UserControler {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<Object> userRegistration(@RequestBody @Valid UserDtoRegistration userDto) {

        MessageRegistration messageRegistration = userService.userRegistration(userDto);

        return ResponseEntity.status(messageRegistration.getHttpStatus()).body(messageRegistration.getMessage());

    }

    @GetMapping
    public ResponseEntity<List<UserDtoDataReturn>> allUsersList() {
        userService.usersList();
        return ResponseEntity.status(HttpStatus.OK).body(userService.usersList());
    }
}
