package com.example.tddjunitmock.controller;

import com.example.tddjunitmock.entity.UserEntity;
import com.example.tddjunitmock.service.UserService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(UserController.class)
public class UserControllerTest {

    @InjectMocks
    private UserController userController;

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @Test
    public void getUser() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                        .get("/get")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json("{\"id\": 1,\"name\":\"MateusMock\",\"login\":mateuspiclover,\"password\":password}"))
                .andReturn();
    }

    @Test
    public void getAllUsers() throws Exception {
        Mockito.when(userService.getAll()).thenReturn(
                Arrays.asList(new UserEntity(1L,"MateusMock","mateuspiclover","password"),
                        new UserEntity(2L,"MariaMock","mariapiclover","password")));

        mockMvc.perform(MockMvcRequestBuilders
                        .get("/get-all")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json("[{\"id\": 1,\"name\":\"MateusMock\"," +
                        "\"login\":mateuspiclover,\"password\":password}, {\"id\": 2," +
                        "\"name\":\"MariaMock\",\"login\":mariapiclover,\"password\":password}]"))
                .andReturn();
    }

    @Test
    public void getAllEmpty() throws Exception {
        Mockito.when(userService.getAll()).thenReturn(
                Arrays.asList());

         mockMvc.perform(MockMvcRequestBuilders
                        .get("/get-all")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json("[]"))
                .andReturn();

    }

    @Test
    public void saveUser() {
        final UserEntity userEntity = userController.save(
                new UserEntity(null, "Jose123", "jose", "password"));
        Assertions.assertThat(userEntity).isNotNull();
    }
}
