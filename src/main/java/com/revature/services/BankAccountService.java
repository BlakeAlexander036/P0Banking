package com.revature.services;

import com.revature.entities.BankAccountEntity;
import com.revature.entities.UserEntity;
import com.revature.repositories.BankAccountRepository;
import com.revature.utilities.DatabaseScriptRunnerUtility;

import java.nio.file.Paths;
import java.util.ArrayList;
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

    public void deposit(double depositAmount) {
        // Business logic for depositing into an account
        // need balance + depost amount


        bankAccountRepository.deposit();
    }

    public void withdraw(double withdrawAmount) {
        // Business logic for withdrawing from an account
        // need to balance - withdraw amount


        bankAccountRepository.withdraw();
    }

    public void viewAccounts() {
        // Business logic for viewing accounts
        bankAccountRepository.viewAccounts();
        // Implement logic to retrieve and return the BankAccount objects based on the executed script.
    }

    public void close(){
        // close the account
        bankAccountRepository.closeAccount();
    }

    //////////////////////////////////////////////////


    // bank account entity
    public BankAccountEntity getBankAccountEntity(){
        return bankAccountRepository.getBankAccountEntity();
    }

    public void setBankAccountEntity(BankAccountEntity bankAccountEntity) {
        bankAccountRepository.setBankAccountEntity(bankAccountEntity);
    }

    // bank account entity balance
    public double getBankAccountBalance(){
        return bankAccountRepository.getBankAccountBalance();
    }

    public void setBankAccountBalance(double balance) {
        bankAccountRepository.setBankAccountBalance(balance);
    }

    // bank account entity user id
    public int getBankAccountUserId(){
        return bankAccountRepository.getBankAccountUserId();
    }

    public void setBankAccountUserId(int userId) {
        bankAccountRepository.setBankAccountUserId(userId);
    }

    // bank account number
    public int getBankAccountNumber(){
        return bankAccountRepository.getBankAccountNumber();
    }

    public void setBankAccountBalance(int bankAccountNumber) {
        bankAccountRepository.setBankAccountBalance(bankAccountNumber);
    }

    // bank account entity list
    public List<BankAccountEntity> getBankAccountEntityList(){
        return bankAccountRepository.getBankAccountEntityList();
    }

    public void setBankAccountEntityList(List<BankAccountEntity> bankAccountEntityList) {
        bankAccountRepository.setBankAccountEntityList(bankAccountEntityList);
    }

    // selected bank account
    public double getBankAccountSelectedBankAccountNumber(){
        return bankAccountRepository.getBankAccountSelectedBankAccountNumber();
    }

    public void setBankAccountSelectedBankAccountNumber(int bankAccountSelectedBankNumber) {
        bankAccountRepository.setBankAccountSelectedBankAccountNumber(bankAccountSelectedBankNumber);
    }
}
