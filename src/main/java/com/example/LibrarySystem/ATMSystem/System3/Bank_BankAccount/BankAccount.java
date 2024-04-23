package com.example.LibrarySystem.ATMSystem.System3.Bank_BankAccount;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BankAccount {
    private int accountNumber;
    private int withdrawLimit;
    private double totalBalance;
    private double availableBalance;
    private int pin;

    public BankAccount(int accountNumber, double totalBalance, double availableBalance, int pin) {
        this.accountNumber = accountNumber;
        this.totalBalance = totalBalance;
        this.availableBalance = availableBalance;
        this.pin = pin;
    }

    public double getAvailableBalance() {
        return availableBalance;
    }

    public void deposit(double amount) {
        totalBalance += amount;
        availableBalance += amount;
    }

    public boolean withdraw(double amount) {
        if (availableBalance >= amount) {
            availableBalance -= amount;
            return true;
        }
        return false;
    }
}
