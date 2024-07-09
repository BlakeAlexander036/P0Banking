package com.revature.entities;

import java.util.ArrayList;
import java.util.List;

public class UserEntity {
    private String username;
    private String password;
    private int accountNuumber;
    private boolean isLoggediIn;

    public UserEntity() {
    }

    // Getters and Setters

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAccountNuumber() {
        return accountNuumber;
    }

    public void setAccountNuumber(int accountNuumber) {
        this.accountNuumber = accountNuumber;
    }

    public boolean isLoggediIn() {
        return isLoggediIn;
    }

    public void setLoggediIn(boolean loggediIn) {
        isLoggediIn = loggediIn;
    }

    // Add account to user

}

