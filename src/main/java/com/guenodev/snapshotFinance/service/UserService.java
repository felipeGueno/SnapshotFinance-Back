package com.guenodev.snapshotFinance.service;

import at.favre.lib.crypto.bcrypt.BCrypt;

import com.guenodev.snapshotFinance.dto.UserDtoRegistration;
import com.guenodev.snapshotFinance.dto.UserDtoUserData;
import com.guenodev.snapshotFinance.entity.Users;
import com.guenodev.snapshotFinance.enums.MessageRegistration;
import com.guenodev.snapshotFinance.exceptions.RegistrationException;
import com.guenodev.snapshotFinance.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
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


        return  Optional.ofNullable(userDtoRegistration)
                .map(userDtoRegistration1 -> tryRegister(userDtoRegistration))
                .orElse(MessageRegistration.EMPTY_DATA);

    }
    private MessageRegistration tryRegister(UserDtoRegistration userDtoRegistration) {

        try {
            if (existsByEmail(Optional.ofNullable(userDtoRegistration.getEmail()).orElseThrow())) {
                        userRepository.save(new Users(null,
                        userDtoRegistration.getName(),
                        userDtoRegistration.getEmail(),
                        bcryptPass(userDtoRegistration.getSenha()),
                        false));
            }
        }catch (NoSuchElementException n){
            return MessageRegistration.EMPTY_EMAIL;
        }
        catch (RegistrationException e) {
            return MessageRegistration.EMAIL_EXISTS;
        }
        return MessageRegistration.SUCCESSFUL_REGISTRATION;
    }

    private String bcryptPass(String email) {

        return BCrypt.withDefaults().hashToString(12,email.toCharArray());
    }

    public boolean existsByEmail(String email) throws RegistrationException {

        if(userRepository.existsByEmail(email)){
            throw new RegistrationException();
        }
        return true;
    }

    public List<UserDtoUserData> usersList() {
        List<UserDtoUserData> usersList = new ArrayList<>();
        userRepository.findAll().forEach(user -> usersList.add(new UserDtoUserData(user)));
        return usersList;
    }


}
