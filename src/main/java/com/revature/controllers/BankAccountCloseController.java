package com.revature.controllers;

import com.revature.services.ApplicationManagerService;
import com.revature.services.BankAccountService;
import com.revature.services.UserService;
import com.revature.views.BankAccountCloseView;

import java.util.Scanner;

public class BankAccountCloseController extends BaseController{

    private BankAccountCloseView bankAccountCloseView;
    private BankAccountService bankAccountService;
    private UserService userService;

    public BankAccountCloseController(Scanner scanner, ApplicationManagerService applicationManagerService, BankAccountService bankAccountService, UserService userService) {
        super(scanner, applicationManagerService);
        this.bankAccountCloseView = new BankAccountCloseView(scanner);
        this.bankAccountService = bankAccountService;
        this.userService = userService;
    }

    // method for calling Terminal view for bank accounts
    public void displayMenu() {
        bankAccountCloseView.displayMenu(userService.getUserEntity(), bankAccountService.getBankAccountEntity());
        String userChoice = bankAccountCloseView.getUserInput();

        // Handle user choice
        // apply action onto enums to see what user has done
        applicationManagerService.applyAction(userChoice);

        // check action enum to decide controller function to call
        switch(applicationManagerService.getActionEnum()){
            case DELETE:
                close();
                break;
            case READ:
                goBackToMenu();
                break;
        }
    }

    public void close() {
        // call the service to close account
        bankAccountService.close();
    }

    public void goBackToMenu(){
        // do nothing,
    }
}