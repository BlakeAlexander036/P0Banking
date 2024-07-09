package com.revature.services;

import com.revature.entities.UserEntity;
import com.revature.repositories.UserRepository;
import com.revature.utilities.PasswordHasherUtility;

public class UserService {
    private UserRepository userRepository;
    private PasswordHasherUtility passwordHasherUtility;

    public UserService() {
        this.userRepository = new UserRepository();
    }

    // Methods for registration, login, and logout
    public void registerUser(String username, String password) {

    }
    public UserEntity loginUser(String username, String password) {
        return null;
    }
    public void logoutUser(UserEntity user) {

    }
}
