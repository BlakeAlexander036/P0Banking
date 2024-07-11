package com.revature.repositories;

import com.revature.entities.BankAccountEntity;
import com.revature.entities.UserEntity;
import com.revature.enums.ActionEnum;
import com.revature.utilities.DatabaseScriptRunnerUtility;

import java.util.List;

public class BankAccountRepository {
    private String fileName;
    BankAccountEntity bankAccountEntity;
    private List<Object> bankAccountResults;

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
        fileName = "bank_account_deposit.sql";
        ActionEnum actionEnum = ActionEnum.DEPOSIT;
        DatabaseScriptRunnerUtility.runSQLScript(fileName, bankAccountEntity, actionEnum);
    }
    public void withdraw() {
        fileName = "bank_account_withdraw.sql";
        ActionEnum actionEnum = ActionEnum.WITHDRAW;
        DatabaseScriptRunnerUtility.runSQLScript(fileName, bankAccountEntity, actionEnum);
    }
    public List<BankAccountEntity> viewAccounts() {
        fileName = "bank_account_view_accounts.sql";
        ActionEnum actionEnum = ActionEnum.READ;
        bankAccountResults = DatabaseScriptRunnerUtility.runSQLSelectScript(fileName, bankAccountEntity, actionEnum);
        return (List<BankAccountEntity>) (List<?>) bankAccountResults;
    }


    /////////////////////////////////////

    public BankAccountEntity getBankAccountEntity() {
        return bankAccountEntity;
    }

    public void setBankAccountEntity(BankAccountEntity bankAccountEntity) {
        this.bankAccountEntity = bankAccountEntity;
    }
}

