package com.revature.controllers;

import com.revature.entities.UserEntity;
import com.revature.services.ApplicationManagerService;
import com.revature.services.BankAccountService;
import com.revature.services.UserService;
import com.revature.views.BankAccountMenuView;

import java.util.Scanner;

public class BankAccountMenuController extends BaseController{
    private BankAccountMenuView bankAccountMenuView;
    private BankAccountService bankAccountService;
    private UserService userService;

    public BankAccountMenuController(Scanner scanner, ApplicationManagerService applicationManagerService, BankAccountService bankAccountService, UserService userService) {
        super(scanner, applicationManagerService);
        this.bankAccountMenuView = new BankAccountMenuView(scanner);
        this.bankAccountService = bankAccountService;
        this.userService = userService;
    }

    // method for calling Terminal view for bank accounts
    public void displayMainMenu() {
        bankAccountMenuView.displayMenu(userService.getUserEntity());
        String userChoice = bankAccountMenuView.getUserInput();

        // Handle user choice
        // apply action onto enums to see what user has done
        applicationManagerService.applyAction(userChoice);

        // check action enum to decide controller function to call
        switch(applicationManagerService.getActionEnum()){
            case DEPOSIT: // Deposit
                deposit();
                break;
            case WITHDRAW: // Withdraw
                withdraw();
                break;
            case EXIT: // Exit
                backToUserMenu();
                break;
        }
    }

    // Methods for handling account creation, deposit, withdraw, view accounts
    public void createAccount() {
        // call the service for crating a bank account
    }
    public void deposit() {
        // call the service to deposit money
        bankAccountService.deposit();

    }
    public void withdraw() {
        // call the service to withdraw money
        bankAccountService.withdraw();

    }

    public void backToUserMenu() {
        // simply go back to the ApplicationManager.run() loop
    }

    public void viewAccounts() {
        // call the service to viewAccounts
    }
}

