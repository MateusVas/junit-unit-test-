package com.example.tddjunitmock.service;

import com.example.tddjunitmock.entity.UserEntity;
import com.example.tddjunitmock.repository.UserRepository;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @InjectMocks
    private UserService userService;

    @Mock
    private UserRepository userRepository;

    @Test
    public void getAllUsers() {
        Mockito.when(userRepository.findAll()).thenReturn(
                Arrays.asList(new UserEntity(1L,"MateusMock","mateuspiclover","password"),
                        new UserEntity(2L,"MariaMock","mariapiclover","password")));

        List<UserEntity> userEntities = userService.getAll();

        assertEquals("MateusMock", userEntities.get(0).getName());
        assertEquals("MariaMock", userEntities.get(1).getName());
    }
}
