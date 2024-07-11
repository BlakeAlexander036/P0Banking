package com.revature.controllers;

import com.revature.services.ApplicationManagerService;
import com.revature.services.BankAccountService;
import com.revature.services.UserService;
import com.revature.views.BankAccountsMenuView;

import java.util.Scanner;

public class BankAccountsMenuController extends BaseController{
    private BankAccountsMenuView bankAccountsMenuView;
    private BankAccountService bankAccountService;
    private UserService userService;

    public BankAccountsMenuController(Scanner scanner, ApplicationManagerService applicationManagerService, BankAccountService bankAccountService, UserService userService) {
        super(scanner, applicationManagerService);
        this.bankAccountsMenuView = new BankAccountsMenuView(scanner);
        this.bankAccountService = bankAccountService;
        this.userService = userService;
    }

    // method for calling Terminal view for bank accounts
    public void displayMainMenu() {
        bankAccountsMenuView.displayMenu(userService.getUserEntity());
        String userChoice = bankAccountsMenuView.getUserInput();

        // Handle user choice
        // apply action onto enums to see what user has done
        applicationManagerService.applyAction(userChoice);

        // check action enum to decide controller function to call
        switch(applicationManagerService.getActionEnum()){
            case READ: // Deposit
                readSelectedBankAccount();
                break;
            case EXIT: // Exit
                backToUserMenu();
                break;
        }
    }

    public void readSelectedBankAccount(){}

    public void backToUserMenu() {}
}
