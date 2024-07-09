package com.revature.entities;

public abstract class BankAccountEntity {
    private String accountNumber;
    private double balance;

    public BankAccountEntity(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }

    // Getters and Setters
    // Abstract methods for deposit and withdraw
}
