package com.example.LibrarySystem.ATMSystem.System3.User_ATMCard;

import com.example.LibrarySystem.ATMSystem.System3.Bank_BankAccount.BankAccount;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {
    private ATMCard card;
    private BankAccount account;

    public User(ATMCard card, BankAccount account) {
        this.card = card;
        this.account = account;
    }

    public void deposit(double amount) {
        account.deposit(amount);
    }

    public boolean withdraw(double amount) {
        return account.withdraw(amount);
    }
}
