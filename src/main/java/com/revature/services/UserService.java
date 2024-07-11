package com.revature.services;

import com.revature.entities.UserEntity;
import com.revature.repositories.UserRepository;
import com.revature.utilities.DatabaseScriptRunnerUtility;
import com.revature.utilities.PasswordHasherUtility;
import com.revature.utilities.ValidatorUtility;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.PreparedStatement;

import static com.revature.utilities.DatabaseScriptRunnerUtility.runSQLScript;

public class UserService {
    private UserRepository userRepository;
    public ValidatorUtility validatorUtility;

    public UserService(UserEntity userEntity) {
        this.userRepository = new UserRepository(userEntity);
        this.validatorUtility = new ValidatorUtility();
    }

    public void registerUser() {
        // Business logic for registering a user
        userRepository.registerUser();
    }


    public void loginUser() {
        // Business logic for logging in a user
        // we need to validate that string is less than equal to 30 characters


        userRepository.loginUser();
    }

    public void logoutUser() {
        // Business logic for getting a user by username
        // set userId to null
        setUserId(-1);

        //set username and password to null;
        setUsername(null);
        setPassword(null);

        // we need to set our user entity logged in to false
        setIsLoggedIn(false);
    }

    public void updateUser() {
        // Business logic for updating a user's password
        userRepository.updateUser();
    }

    public UserEntity getUserEntity(){
        return userRepository.getUserEntity();
    }

    public void setUsername(String username){
        userRepository.getUserEntity().setUsername(username);
    }

    public void setPassword(String password){
        userRepository.getUserEntity().setPassword(password);
    }

    public void setIsLoggedIn(boolean bool){
        userRepository.getUserEntity().setIsLoggedIn(bool);
    }

    public boolean getIsLoggedIn(){
        return userRepository.getUserEntity().getIsLoggedIn();
    }

    public int getUserId(){
        return userRepository.getUserEntity().getUserId();
    }

    public void setUserId(int userId){
        userRepository.getUserEntity().setUserId(userId);
    }
}
