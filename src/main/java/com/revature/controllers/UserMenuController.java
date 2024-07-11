package com.revature.controllers;

import com.revature.services.ApplicationManagerService;
import com.revature.services.BankAccountService;
import com.revature.services.UserService;
import com.revature.views.UserMenuView;

import java.util.Scanner;

public class UserMenuController extends BaseController{
    private UserMenuView userMenuView;
    private UserService userService;
    private BankAccountService bankAccountService;


    public UserMenuController(Scanner scanner, ApplicationManagerService applicationManagerService, UserService userService, BankAccountService bankAccountService) {
        super(scanner, applicationManagerService);
        this.userService = userService;
        this.bankAccountService = bankAccountService;
        this.userMenuView = new UserMenuView(scanner);
    }

    public void displayMenu() {
        userMenuView.displayMenu(userService.getUserEntity());
        String userChoice = userMenuView.getUserInput();

        // Handle user choice
        // apply action onto enums to see what user has done
        applicationManagerService.applyAction(userChoice);

        // check action enum to decide controller function to call
        switch(applicationManagerService.getActionEnum()){
            case CREATE: // Create Bank Account
                createBankAccount();
                userMenuView.displayBankAccountCreated(bankAccountService.getBankAccountEntity());
                break;
            case READ: // View Bank Accounts
                viewBankAccounts();
                break;
            case EXIT: // Exit
                logout();
                break;
        }
    }

    public void createBankAccount(){
        // we need the userId to create an account
        bankAccountService.createAccount(userService.getUserEntity());
    }

    public void viewBankAccounts(){
        // we need to initilize the bank account list / bank account
        // you should already be logged in, set bank entity user id to user id
        bankAccountService.setBankAccountUserId(userService.getUserId());
        bankAccountService.viewAccounts();

    }

    public void logout(){
        userService.logoutUser();
    }

}

