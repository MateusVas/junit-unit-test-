package com.example.tddjunitmock.repository;

import com.example.tddjunitmock.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long>{

}
