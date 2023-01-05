package com.example.tddjunitmock.controller;

import com.example.tddjunitmock.entity.UserEntity;
import com.example.tddjunitmock.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/get")
    public UserEntity getUser() {
        return new UserEntity(1L, "MateusMock", "mateuspiclover", "password");
    }

    @GetMapping("/item-from-business-service")
    public UserEntity itemFromBusinessService() {
        UserEntity item = userService.retreiveHardcodedItem();

        return item;
    }

    @GetMapping("/get-all")
    public List<UserEntity> getAllUsers() {
        return userService.getAll();
    }

    @PostMapping
    public UserEntity save(UserEntity userEntity) {
        return userEntity;
    }
}
