drop table if exists "user";

create table "user"(
	user_id integer PRIMARY KEY autoincrement,
	username text,
	password text
);

create table BankAccount(
	bank_account_number integer PRIMARY KEY autoincrement,
	balance
	user_id integer not null REFERENCES "user"(user_id)
);