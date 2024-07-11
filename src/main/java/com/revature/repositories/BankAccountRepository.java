package com.revature.repositories;

import com.revature.entities.BankAccountEntity;
import com.revature.entities.UserEntity;
import com.revature.enums.ActionEnum;
import com.revature.utilities.DatabaseScriptRunnerUtility;

import java.util.List;

public class BankAccountRepository {
    private String fileName;
    private BankAccountEntity bankAccountEntity;
    private List<Object> bankAccountResults;
    private List<BankAccountEntity> bankAccountEntityList;
    private int selectedBankAccount;

    public BankAccountRepository(BankAccountEntity bankAccountEntity){
        this.bankAccountEntity = bankAccountEntity;
    }
    // Methods for CRUD operations
    // Methods for creating accounts, deposit, withdraw, view accounts
    public void createAccount() {
        fileName = "bank_account_create_account.sql";
        ActionEnum actionEnum = ActionEnum.CREATE;
        DatabaseScriptRunnerUtility.runSQLScript(fileName, bankAccountEntity, actionEnum);
    }
    public void deposit() {
        fileName = "bank_account_update_balance.sql";
        ActionEnum actionEnum = ActionEnum.UPDATE;
        DatabaseScriptRunnerUtility.runSQLScript(fileName, bankAccountEntity, actionEnum);
    }
    public void withdraw() {
        fileName = "bank_account_update_balance.sql";
        ActionEnum actionEnum = ActionEnum.UPDATE;
        DatabaseScriptRunnerUtility.runSQLScript(fileName, bankAccountEntity, actionEnum);
    }
    public void viewAccounts() {
        fileName = "bank_account_view_accounts.sql";
        ActionEnum actionEnum = ActionEnum.READ;
        bankAccountResults = DatabaseScriptRunnerUtility.runSQLSelectScript(fileName, bankAccountEntity, actionEnum);
        bankAccountEntityList = (List<BankAccountEntity>) (List<?>) bankAccountResults;
    }

    public void closeAccount() {
        fileName = "bank_account_delete_account.sql";
        ActionEnum actionEnum = ActionEnum.DELETE;
        DatabaseScriptRunnerUtility.runSQLScript(fileName, bankAccountEntity, actionEnum);
    }


    /////////////////////////////////////

    public BankAccountEntity getBankAccountEntity() {
        return bankAccountEntity;
    }

    public void setBankAccountEntity(BankAccountEntity bankAccountEntity) {
        this.bankAccountEntity = bankAccountEntity;
    }

    public List<BankAccountEntity> getBankAccountEntityList(){
        return bankAccountEntityList;
    }

    public void setBankAccountEntityList(List<BankAccountEntity> bankAccountEntityList) {
        this.bankAccountEntityList = bankAccountEntityList;
    }

    // bank account entity balance
    public double getBankAccountBalance(){
        return bankAccountEntity.getBalance();
    }

    public void setBankAccountBalance(double balance) {
        this.bankAccountEntity.setBalance(balance);
    }

    // bank account entity user id
    public int getBankAccountUserId(){
        return bankAccountEntity.getUserId();
    }

    public void setBankAccountUserId(int userId) {
        this.bankAccountEntity.setUserId(userId);
    }

    // bank account number
    public int getBankAccountNumber(){
        return bankAccountEntity.getAccountNumber();
    }

    public void setBankAccountBalance(int bankAccountNumber) {
        this.bankAccountEntity.setAccountNumber(bankAccountNumber);
    }


    // selected bank account
    public double getBankAccountSelectedBankAccountNumber(){
        return this.selectedBankAccount;
    }

    public void setBankAccountSelectedBankAccountNumber(int bankAccountSelectedBankNumber) {
        this.selectedBankAccount = bankAccountSelectedBankNumber;
    }
}

