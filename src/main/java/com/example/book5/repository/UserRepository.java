package com.example.book5.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.book5.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Integer>{
	UserEntity findByUsername(String username);
}
