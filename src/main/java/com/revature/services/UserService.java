package com.revature.services;

import com.revature.entities.UserEntity;
import com.revature.repositories.UserRepository;
import com.revature.utilities.DatabaseScriptRunnerUtility;
import com.revature.utilities.PasswordHasherUtility;

import java.nio.file.Path;
import java.nio.file.Paths;

import static com.revature.utilities.DatabaseScriptRunnerUtility.runSQLScript;

public class UserService {
    private UserRepository userRepository;

    public UserService(UserEntity userEntity) {
        this.userRepository = new UserRepository(userEntity);
    }

    public void registerUser() {
        // Business logic for registering a user
        userRepository.registerUser();
    }

    public void loginUser() {
        // Business logic for logging in a user
        userRepository.loginUser();
    }

    public void logoutUser() {
        // Business logic for getting a user by username
        userRepository.logoutUser();
    }

    public void updateUser() {
        // Business logic for updating a user's password
        userRepository.updateUser();
    }
}
