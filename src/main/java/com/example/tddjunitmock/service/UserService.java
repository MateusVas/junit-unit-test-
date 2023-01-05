package com.example.tddjunitmock.service;

import com.example.tddjunitmock.entity.UserEntity;
import com.example.tddjunitmock.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserEntity retreiveHardcodedItem() {
        return new UserEntity();
    }

    public List<UserEntity> getAll() {
        return userRepository.findAll();
    }
}
