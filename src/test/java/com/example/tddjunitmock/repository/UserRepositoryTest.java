package com.example.tddjunitmock.repository;

import com.example.tddjunitmock.entity.UserEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void findAllEmpty() {
        List<UserEntity> userEntities = userRepository.findAll();
        assertEquals(0,userEntities.size());
    }

}
