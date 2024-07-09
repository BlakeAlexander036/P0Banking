package com.revature.services;

import com.revature.entities.UserEntity;
import com.revature.repositories.UserRepository;
import com.revature.utilities.PasswordHasherUtility;

public class UserService {
    private UserRepository userRepository;
    private PasswordHasherUtility passwordHasherUtility;

    public UserService(UserRepository userRepository, PasswordHasherUtility passwordHasherUtility) {
        this.userRepository = userRepository;
        this.passwordHasherUtility = passwordHasherUtility;
    }

    // Methods for registration, login, and logout
    public void registerUser(String username, String password) {}
    public UserEntity loginUser(String username, String password) {}
    public void logoutUser(UserEntity user) {}
}
