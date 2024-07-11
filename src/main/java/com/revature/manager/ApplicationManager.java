package com.revature.manager;

import com.revature.controllers.*;
import com.revature.entities.BankAccountEntity;
import com.revature.entities.UserEntity;
import com.revature.entities.UserInputEntity;
import com.revature.exceptions.UnhandledException;
import com.revature.services.ApplicationManagerService;
import com.revature.services.BankAccountService;
import com.revature.services.UserService;
import com.revature.enums.*;

import java.util.Scanner;

public class ApplicationManager {
    //Scanner
    Scanner scanner;

    // Controllers
    private UserMenuController userMenuController;
    private BankAccountsMenuController bankAccountsMenuController;
    private BankAccountMenuController bankAccountMenuController;
    private BankAccountDepositController bankAccountDepositController;
    private BankAccountWithdrawController bankAccountWithdrawController;
    private UserLoginMenuController userLoginMenuController;
    private MainMenuController mainMenuController;
    private UserRegisterMenuController userRegisterMenuController;
    private BankAccountCloseController bankAccountCloseController;

    // Services
    private BankAccountService bankAccountService;
    private UserService userService;
    private ApplicationManagerService applicationManagerSerive;

    // Entities
    private UserEntity userEntity;
    private BankAccountEntity bankAccountEntity;
    public UserInputEntity userInputEntity;



    public ApplicationManager(Scanner scanner) {
        this.scanner = scanner;

        // Initialize entities, repositories, services, controllers, and views

        //Entities
        this.userEntity = new UserEntity();
        this.bankAccountEntity = new BankAccountEntity();
        this.userInputEntity = new UserInputEntity();

        // Services
        this.bankAccountService = new BankAccountService(bankAccountEntity);
        this.userService = new UserService(userEntity);
        this.applicationManagerSerive = new ApplicationManagerService(userInputEntity);


        // Controllers
        this.mainMenuController = new MainMenuController(scanner, applicationManagerSerive,userService); // this needs a UserService to display who is logged in
        this.bankAccountMenuController = new BankAccountMenuController(scanner, applicationManagerSerive,bankAccountService, userService); // this needs a BankAccountService
        this.bankAccountsMenuController = new BankAccountsMenuController(scanner, applicationManagerSerive,bankAccountService, userService); // this needs a BankAccountService
        this.userMenuController = new UserMenuController(scanner, applicationManagerSerive,userService, bankAccountService); // this needs the UserService to display who is logged in
        this.userLoginMenuController = new UserLoginMenuController(scanner, applicationManagerSerive,userService); // this needs the UserService
        this.userRegisterMenuController = new UserRegisterMenuController(scanner, applicationManagerSerive,userService); // this needs the UserService
        this.bankAccountDepositController = new BankAccountDepositController(scanner, applicationManagerSerive,bankAccountService, userService); // this needs a BankAccountService
        this.bankAccountWithdrawController = new BankAccountWithdrawController(scanner, applicationManagerSerive,bankAccountService, userService); // this needs a BankAccountService
        this.bankAccountCloseController = new BankAccountCloseController(scanner, applicationManagerSerive,bankAccountService, userService); // this needs a BankAccountService
    }

    // Method to run the application
    public void run() {

        // THIS IS THE PLAN
        /*
            we will have an enum that contains every possible user input option for changing a controller, that
            enum will then call the controller we want.
        */

        // Main loop for the application
        while(userInputEntity.getControllerEnum() != ControllerEnum.NONE){
            // WE JUST WANT CONTROLLERS HERE IM PRETTY SURE
            switch(userInputEntity.getControllerEnum()){
                case MAIN_MENU:
                    mainMenuController.displayMenu();
                    break;
                case USER_MENU:
                    userMenuController.displayMenu();
                    break;
                case LOGIN_MENU:
                    userLoginMenuController.displayMenu();
                    break;
                case REGISTRATION_MENU:
                    userRegisterMenuController.displayMenu();
                    break;
                case BANK_ACCOUNTS_MENU:
                    bankAccountsMenuController.displayMenu();
                    break;
                case BANK_ACCOUNT_MENU:
                    bankAccountMenuController.displayMenu();
                    break;
                case BANK_ACCOUNT_DEPOSIT:
                    bankAccountDepositController.displayMenu();
                    break;
                case BANK_ACCOUNT_WITHDRAW:
                    bankAccountWithdrawController.displayMenu();
                    break;
                case BANK_ACCOUNT_CLOSE:
                    bankAccountCloseController.displayMenu();
                    break;
                case NONE:
                    break;
                default:
                    throw new UnhandledException("where are we");
            }

        }
    }
}
