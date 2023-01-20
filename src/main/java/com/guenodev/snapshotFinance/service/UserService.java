package com.guenodev.snapshotFinance.service;

import at.favre.lib.crypto.bcrypt.BCrypt;

import com.guenodev.snapshotFinance.dto.UserDtoRegistration;
import com.guenodev.snapshotFinance.dto.UserDtoDataReturn;
import com.guenodev.snapshotFinance.entity.Users;
import com.guenodev.snapshotFinance.enums.MessageRegistration;
import com.guenodev.snapshotFinance.exceptions.RegistrationException;
import com.guenodev.snapshotFinance.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private GroupService groupService;

    /** Verify existent email
     * Cripto Pass
     * Register User
     * */


    public MessageRegistration userRegistration(UserDtoRegistration userDtoRegistration) {

        try {

            if (Optional.ofNullable(userDtoRegistration.getEmail()).isPresent()){
                existsByEmail(userDtoRegistration.getEmail());
            }
        } catch (RegistrationException e){
            return e.getMessageRegistration();
        }

        userRepository.save(Users.builder()
                .name(userDtoRegistration.getName())
                .email(userDtoRegistration.getEmail())
                .senha(bcryptPass(userDtoRegistration.getSenha()))
                .build());

        return MessageRegistration.SUCCESSFUL_REGISTRATION;

    }

    private String bcryptPass(String email) {

        return BCrypt.withDefaults().hashToString(12,email.toCharArray());
    }

    public void existsByEmail(String email) throws RegistrationException {
        if(userRepository.existsByEmail(email)){
            throw new RegistrationException(MessageRegistration.EMAIL_EXISTS);
        }
    }
    public List<UserDtoDataReturn> usersList() {
        List<UserDtoDataReturn> usersList = new ArrayList<>();
        userRepository.findAll().forEach(user -> usersList.add(new UserDtoDataReturn(user)));
        return usersList;
    }


}
