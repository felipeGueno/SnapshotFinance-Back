package com.guenodev.snapshotFinance.controller;

import com.guenodev.snapshotFinance.dto.UserDtoRegistration;
import com.guenodev.snapshotFinance.dto.UserDtoUserData;
import com.guenodev.snapshotFinance.entity.Users;
import com.guenodev.snapshotFinance.exceptions.RegistrationException;
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
    public ResponseEntity<Object> userRegistration(@RequestBody @Valid UserDtoRegistration userDto) throws RegistrationException {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.userRegistration(userDto));

    }

    @GetMapping
    public ResponseEntity<List<UserDtoUserData>> allUsersList() {
        userService.usersList();
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.usersList());
    }
}
