package com.example.book5.service;

import com.example.book5.entity.UserEntity;

public interface UserService {
	UserEntity addUser(UserEntity entity);
	boolean isUserLoggedIn();

}
