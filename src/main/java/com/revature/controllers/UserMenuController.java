package com.revature.controllers;

import com.revature.entities.UserEntity;
import com.revature.services.ApplicationManagerService;
import com.revature.services.BankAccountService;
import com.revature.services.UserService;
import com.revature.views.MainMenuView;
import com.revature.views.UserMenuView;

import java.util.Scanner;

public class UserMenuController extends BaseController{
    private UserMenuView userMenuView;
    private UserService userService;
    private BankAccountService bankAccountService;


    public UserMenuController(Scanner scanner, ApplicationManagerService applicationManagerService, UserService userService, BankAccountService bankAccountService) {
        super(scanner, applicationManagerService);
        this.userMenuView = new UserMenuView(scanner);
        this.userService = userService;
        this.bankAccountService = bankAccountService;
    }

    public void displayMainMenu() {
        userMenuView.displayMenu();
        String userChoice = userMenuView.getUserInput();

        // Handle user choice
        // apply action onto enums to see what user has done
        applicationManagerService.applyAction(userChoice);

        // check action enum to decide controller function to call
        switch(applicationManagerService.getActionEnum()){
            case CREATE: // Create Bank Account
                createBankAccount();
                break;
            case READ: // View Bank Accounts
                viewBankAccount();
                break;
            case EXIT: // Exit
                logout();
                break;
        }
    }

    public void createBankAccount(){
        bankAccountService.createAccount();
    }

    public void viewBankAccount(){
        bankAccountService.viewAccounts();
    }

    public void logout(){
        userService.logoutUser();
    }

}

