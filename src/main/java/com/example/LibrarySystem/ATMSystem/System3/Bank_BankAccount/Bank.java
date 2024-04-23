package com.example.LibrarySystem.ATMSystem.System3.Bank_BankAccount;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.example.LibrarySystem.ATMSystem.System3.ATM_ATMRoom.ATM;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Bank {
    private String name;
    private String bankCode;
    private HashMap<String, BankAccount> accounts;
    private List<ATM> atms;

    public Bank(String name, String bankCode) {
        this.name = name;
        this.bankCode = bankCode;
        this.accounts = new HashMap<>();
        this.atms = new ArrayList<>();
    }

    public void addAccount(String cardNumber, BankAccount account) {
        accounts.put(cardNumber, account);
    }

    public void addATM(ATM atm) {
        atms.add(atm);
    }
}
