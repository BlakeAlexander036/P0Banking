package com.revature.controllers;

import com.revature.entities.UserEntity;
import com.revature.services.BankAccountService;
import com.revature.views.BankAccountMenuView;

import java.util.Scanner;

public class BankAccountMenuController {
    private BankAccountMenuView bankAccountMenuView;
    private BankAccountService bankAccountService;
    String userInput;
    private Scanner scanner;

    public BankAccountMenuController(Scanner scanner, BankAccountService bankAccountService) {
        this.scanner = scanner;
        this.bankAccountMenuView = new BankAccountMenuView(scanner);
        this.bankAccountService = bankAccountService;
    }

    // method for calling Terminal view for bank accounts
    public void displayMainMenu() {
        bankAccountMenuView.displayMenu();
        userInput = bankAccountMenuView.getUserInput();

        // Handle user choice
        switch(userInput){
            case "1":
                deposit();
                break;
            case "2":
                withdraw();
                break;
            case "3":;
                viewAccounts();
                break;
            case "4":
                backToUserMenu();
                break;
            default:
                System.out.println("Error: not a valid input. Please try again");
                displayMainMenu();
        }
    }

    // Methods for handling account creation, deposit, withdraw, view accounts
    public void createAccount() {
        // call the service for crating a bank account
    }
    public void deposit() {
        // call the service to deposit money
    }
    public void withdraw() {
        // call the service to withdraw money
    }
    public void viewAccounts() {
        // call the service to viewAccounts
    }

    public void backToUserMenu() {
        //
    }
}

