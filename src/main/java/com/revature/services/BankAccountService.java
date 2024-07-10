package com.revature.services;

import com.revature.entities.BankAccountEntity;
import com.revature.entities.UserEntity;
import com.revature.repositories.BankAccountRepository;
import com.revature.utilities.DatabaseScriptRunnerUtility;

import java.nio.file.Paths;
import java.util.List;

import static com.revature.utilities.DatabaseScriptRunnerUtility.runSQLScript;

public class BankAccountService {
    private BankAccountRepository bankAccountRepository;

    public BankAccountService(BankAccountEntity bankAccountEntity) {
        this.bankAccountRepository = new BankAccountRepository(bankAccountEntity);
    }

    public void createAccount() {
        // Business logic for creating an account
        bankAccountRepository.createAccount();
    }

    public void deposit() {
        // Business logic for depositing into an account
        bankAccountRepository.deposit();
    }

    public void withdraw() {
        // Business logic for withdrawing from an account
        bankAccountRepository.withdraw();
    }

    public void viewAccounts() {
        // Business logic for viewing accounts
        bankAccountRepository.viewAccounts();
        // Implement logic to retrieve and return the BankAccount objects based on the executed script.
    }

    public BankAccountEntity getBankAccountEntity(){
        return bankAccountRepository.getBankAccountEntity();
    }
}
