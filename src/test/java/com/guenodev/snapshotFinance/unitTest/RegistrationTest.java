package com.guenodev.snapshotFinance.unitTest;


import com.guenodev.snapshotFinance.dto.UserDtoRegistration;
import com.guenodev.snapshotFinance.entity.Users;
import com.guenodev.snapshotFinance.exceptions.RegistrationException;
import com.guenodev.snapshotFinance.repository.UserRepository;
import com.guenodev.snapshotFinance.service.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.UUID;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class RegistrationTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    Users users;

    UserDtoRegistration userDto;

   /*
   @BeforeEach
    void setup(){
        users = new Users(UUID.randomUUID(),"Felipe Moretti", "felipemoretti@outlook.com","12345",false);
        userDto = new UserDtoRegistration(users.getName(),users.getEmail(),users.getSenha());
    }
    */

    /* @Test
    @DisplayName("Should return Registration Exception when email already exists")
    public void shouldReturnRegistrationExceptionWhenEmailAlreadyExists() throws RegistrationException {

        when(userService.existsByEmail(Mockito.any())).thenReturn(true);

        Exception exception = Assertions.assertThrows(Exception.class, () -> userService.userRegistration(userDto));
        */

//        Assertions.assertEquals("This e-mail already exists! Please try another one or contact us", exception.getMessage());


    }

