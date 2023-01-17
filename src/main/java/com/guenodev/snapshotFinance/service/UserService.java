package com.guenodev.snapshotFinance.service;


import com.guenodev.snapshotFinance.dto.UserDtoRegistration;
import com.guenodev.snapshotFinance.dto.UserDtoUserData;
import com.guenodev.snapshotFinance.entity.Users;
import com.guenodev.snapshotFinance.exceptions.RegistrationException;
import com.guenodev.snapshotFinance.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private GroupService groupService;

    public boolean existsByEmail(String email) {

        return userRepository.existsByEmail(email);
    }

    public Object userRegistration(UserDtoRegistration userDto) throws RegistrationException {

        if (existsByEmail(userDto.getEmail())) {
            throw new RegistrationException("This e-mail already exists! Please try another one or contact us");
        }
        userRepository.save(new Users(null, userDto.getName(), userDto.getEmail(), userDto.getSenha(), false));

        return "Welcome " + userDto.getName();
    }

    public List<UserDtoUserData> usersList() {
        List<UserDtoUserData> usersList = new ArrayList<>();
        userRepository.findAll().forEach(user -> usersList.add(new UserDtoUserData(user.getName(), user.getEmail())));
        return usersList;
    }
}
