package com.revature.services;

import com.revature.entities.BankAccountEntity;
import com.revature.entities.UserEntity;
import com.revature.repositories.BankAccountRepository;

import java.util.List;

public class BankAccountService {
    private BankAccountRepository bankAccountRepository;

    public BankAccountService() {
        this.bankAccountRepository = new BankAccountRepository();
    }

    // Methods for creating accounts, deposit, withdraw, view accounts
    public void createAccount(UserEntity user, String accountNumber, double initialBalance) {

    }
    public void deposit(String accountNumber, double amount) {

    }
    public void withdraw(String accountNumber, double amount) {

    }
    public List<BankAccountEntity> viewAccounts(UserEntity user) {
        return null;
    }
}
