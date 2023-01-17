package com.guenodev.snapshotFinance.integrationTest.controller;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.guenodev.snapshotFinance.controller.UserControler;
import com.guenodev.snapshotFinance.entity.Users;
import com.guenodev.snapshotFinance.service.UserService;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;


import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@ExtendWith(MockitoExtension.class)

@WebMvcTest(UserControler.class)
class UserControllerTest {

    @MockBean
    UserService userService;

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    Users users;


    @BeforeEach
    void setup() {
        users = new Users(1, "Joao Carvalho", "joaoc@outlook.com", "12345", false);

    }

    @Test
    @DisplayName("Should execute user registration")
    public void shouldExecuteUserRegistration() throws Exception {

        when(userService.userRegistration(any())).thenReturn(users);

        MvcResult result = mockMvc.perform(post("/users")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(users)))
                .andExpect(status().isCreated())
                .andReturn();

        //Response em String
        String responseStr = result.getResponse().getContentAsString();

        //String em Objeto
        Users responseObj = objectMapper.readValue(responseStr, Users.class);

        Assertions.assertAll(
                () -> Assertions.assertEquals(users.getName(), responseObj.getName()),
                () -> Assertions.assertEquals(users.getEmail(), responseObj.getEmail()),
                () -> Assertions.assertEquals(users.getSenha(), responseObj.getSenha()
                )
        );

    }
}
