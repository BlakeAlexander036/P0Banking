package com.revature.controllers;

import com.revature.entities.UserEntity;
import com.revature.services.UserService;

public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // Methods for handling user registration, login, logout
    public void register(String username, String password) {}
    public void login(String username, String password) {}
    public void logout(UserEntity user) {}
}

