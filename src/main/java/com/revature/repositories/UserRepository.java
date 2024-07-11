package com.revature.repositories;

import com.revature.entities.UserEntity;
import com.revature.enums.ActionEnum;
import com.revature.utilities.DatabaseScriptRunnerUtility;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class UserRepository {
    private String fileName;
    private UserEntity userEntity;
    private List<Object> userResults;

    public UserRepository(UserEntity userEntity){
        this.userEntity = userEntity;
        this.userResults = new ArrayList<>();
    }
    // Methods for registration, login, and logout
    public void registerUser() {
        // path to register
        fileName = "user_register.sql";
        ActionEnum actionEnum = ActionEnum.CREATE;
        DatabaseScriptRunnerUtility.runSQLScript(fileName, userEntity, actionEnum);
        loginUser();
    }
    public void loginUser() {
        fileName = "user_login.sql";
        ActionEnum actionEnum = ActionEnum.READ;
        userResults = DatabaseScriptRunnerUtility.runSQLSelectScript(fileName, userEntity, actionEnum);
        if(userResults.isEmpty()){
            userEntity.setIsLoggedIn(false);
        } else {
            userEntity = (UserEntity) userResults.get(0);
            userEntity.setIsLoggedIn(true);
        }
    }
    public void logoutUser() {
        fileName = "user_logout.sql";
        ActionEnum actionEnum = ActionEnum.EXIT;
        //DatabaseScriptRunnerUtility.runSQLScript(fileName, userEntity, actionEnum);
    }

    public void updateUser() {
        fileName = "user_update.sql";
        ActionEnum actionEnum = ActionEnum.UPDATE_USER;
        DatabaseScriptRunnerUtility.runSQLScript(fileName, userEntity, actionEnum);
    }


    ////////
    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }
}

