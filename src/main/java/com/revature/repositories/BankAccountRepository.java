package com.revature.repositories;

import com.revature.entities.BankAccountEntity;
import com.revature.utilities.DatabaseScriptRunnerUtility;

import java.util.List;

public class BankAccountRepository {
    private String fileName;
    BankAccountEntity bankAccountEntity;

    public BankAccountRepository(BankAccountEntity bankAccountEntity){
        this.bankAccountEntity = bankAccountEntity;
    }
    // Methods for CRUD operations
    // Methods for creating accounts, deposit, withdraw, view accounts
    public void createAccount() {
        fileName = "bank_account_create_account.sql";
        DatabaseScriptRunnerUtility.runSQLScript(fileName, bankAccountEntity);
    }
    public void deposit() {
        fileName = "bank_account_deposit.sql";
        DatabaseScriptRunnerUtility.runSQLScript(fileName, bankAccountEntity);
    }
    public void withdraw() {
        fileName = "bank_account_withdraw.sql";
        DatabaseScriptRunnerUtility.runSQLScript(fileName, bankAccountEntity);
    }
    public List<BankAccountEntity> viewAccounts() {
        fileName = "bank_account_view_accounts.sql";
        DatabaseScriptRunnerUtility.runSQLScript(fileName, bankAccountEntity);
        return null;
    }
}

