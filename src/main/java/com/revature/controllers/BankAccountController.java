package com.revature.controllers;

import com.revature.entities.UserEntity;
import com.revature.services.BankAccountService;

public class BankAccountController {
    private BankAccountService bankAccountService;

    public BankAccountController(BankAccountService bankAccountService) {
        this.bankAccountService = bankAccountService;
    }

    // Methods for handling account creation, deposit, withdraw, view accounts
    public void createAccount(UserEntity user, String accountNumber, double initialBalance) {}
    public void deposit(String accountNumber, double amount) {}
    public void withdraw(String accountNumber, double amount) {}
    public void viewAccounts(UserEntity user) {}
}

