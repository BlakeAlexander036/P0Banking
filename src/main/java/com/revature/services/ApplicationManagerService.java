package com.revature.services;
/*
    we want this service to convert user input to enum that we want
 */

import com.revature.entities.UserInputEntity;
import com.revature.enums.ActionEnum;
import com.revature.enums.ControllerEnum;
import com.revature.exceptions.UnhandledException;

public class ApplicationManagerService {

    private UserInputEntity userInputEntity;


    public ApplicationManagerService(UserInputEntity userInputEntity){
        this.userInputEntity = userInputEntity;
    }

    // we need a method to change the enum depending on the controller and values inputted

    // user input, check the ControllerEnum we are in to go to the correct menu for deciding on action, then change ActionEnum based on that input

    public void applyAction(String inputString){
        // update input string
        userInputEntity.setUserInputString(inputString);

        // what controller/view are we in
        switch(userInputEntity.getControllerEnum()){
            case MAIN_MENU:
                mainMenu();
                break;
            case USER_MENU:
                userMenu();
                break;
            case LOGIN_MENU:
                loginMenu();
                break;
            case REGISTRATION_MENU:
                registrationMenu();
                break;
            case BANK_ACCOUNT_MENU:
                bankAccountMenu();
                break;
            default:
                throw new UnhandledException("where are we");
        }

    }

    public void mainMenu(){
        switch(userInputEntity.getUserInputString()){
            case "1": //Registering
                userInputEntity.setActionEnum(ActionEnum.CREATE);
                userInputEntity.setControllerEnum(ControllerEnum.REGISTRATION_MENU);
                break;
            case "2": // Login
                userInputEntity.setActionEnum(ActionEnum.READ);
                userInputEntity.setControllerEnum(ControllerEnum.LOGIN_MENU);
                break;
            case "3": // Exit
                userInputEntity.setActionEnum(ActionEnum.EXIT);
                userInputEntity.setControllerEnum(ControllerEnum.NONE);
                break;
        }
    }

    public void userMenu(){
        switch(userInputEntity.getUserInputString()){
            case "1": // Create Bank Account
                userInputEntity.setActionEnum(ActionEnum.CREATE);
                userInputEntity.setControllerEnum(ControllerEnum.BANK_ACCOUNT_MENU);
                break;
            case "2": // View Bank Accounts
                userInputEntity.setActionEnum(ActionEnum.READ);
                userInputEntity.setControllerEnum(ControllerEnum.BANK_ACCOUNT_MENU);
                break;
            case "3": // Logout
                userInputEntity.setActionEnum(ActionEnum.EXIT);
                userInputEntity.setControllerEnum(ControllerEnum.MAIN_MENU);
                break;
        }
    }

    // once logged in, go to user menu
    public void loginMenu(){
        userInputEntity.setActionEnum(ActionEnum.READ);
        userInputEntity.setControllerEnum(ControllerEnum.USER_MENU);

        // the user service should check if username is empty, if so, update username, otherwise update password
    }

    // once logged in, go to user menu
    public void registrationMenu(){
        userInputEntity.setActionEnum(ActionEnum.CREATE);
        userInputEntity.setControllerEnum(ControllerEnum.USER_MENU);

        // the user service should check if username is empty, if so, update username, otherwise update password
    }

    public void bankAccountMenu(){
        switch(userInputEntity.getUserInputString()){
            case "1": // deposit
                userInputEntity.setActionEnum(ActionEnum.DEPOSIT);
                userInputEntity.setControllerEnum(ControllerEnum.BANK_ACCOUNT_MENU);
                break;
            case "2": // withdraw
                userInputEntity.setActionEnum(ActionEnum.WITHDRAW);
                userInputEntity.setControllerEnum(ControllerEnum.BANK_ACCOUNT_MENU);
                break;
            case "3": // back to user menu
                userInputEntity.setActionEnum(ActionEnum.EXIT);
                userInputEntity.setControllerEnum(ControllerEnum.USER_MENU);
                break;
        }
    }

    public ControllerEnum getControllerEnum(){
        return userInputEntity.getControllerEnum();
    }

    public ActionEnum getActionEnum(){
        return userInputEntity.getActionEnum();
    }

}
