-- SQL scripts for creating database schema
CREATE TABLE users (
    username VARCHAR(30) PRIMARY KEY,
    password VARCHAR(30)
);

CREATE TABLE bank_accounts (
    account_number VARCHAR(20) PRIMARY KEY,
    balance DOUBLE,
    user_username VARCHAR(30),
    FOREIGN KEY (user_username) REFERENCES users(username)
);
