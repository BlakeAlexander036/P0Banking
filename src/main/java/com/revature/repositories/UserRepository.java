package com.revature.repositories;

import com.revature.entities.UserEntity;
import com.revature.utilities.DatabaseScriptRunnerUtility;

public class UserRepository {
    private String fileName;
    UserEntity userEntity;

    public UserRepository(UserEntity userEntity){
        this.userEntity = userEntity;
    }
    // Methods for registration, login, and logout
    public void registerUser() {
        // path to register
        fileName = "user_register.sql";
        DatabaseScriptRunnerUtility.runSQLScript(fileName, userEntity);
    }
    public UserEntity loginUser() {
        fileName = "user_login.sql";
        DatabaseScriptRunnerUtility.runSQLScript(fileName, userEntity);
        return null;
    }
    public void logoutUser() {
        fileName = "user_logout.sql";
        DatabaseScriptRunnerUtility.runSQLScript(fileName, userEntity);
    }

    public void updateUser() {
        fileName = "user_update.sql";
        DatabaseScriptRunnerUtility.runSQLScript(fileName, userEntity);
    }
}

