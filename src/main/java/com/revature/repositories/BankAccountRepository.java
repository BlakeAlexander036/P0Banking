package com.revature.repositories;

import com.revature.entities.BankAccountEntity;

public class BankAccountRepository {
    // Methods for CRUD operations
    public void addAccount(BankAccountEntity account) {}
    public BankAccountEntity getAccountByNumber(String accountNumber) {}
    public void updateAccount(BankAccountEntity account) {}
    public void deleteAccount(String accountNumber) {}
}

