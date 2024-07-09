package com.revature.entities;

import java.util.ArrayList;
import java.util.List;

public class UserEntity {
    private String username;
    private String password;
    private List<BankAccountEntity> accounts;

    public UserEntity(String username, String password) {
        this.username = username;
        this.password = password;
        this.accounts = new ArrayList<>();
    }

    // Getters and Setters
    // Add account to user
}

