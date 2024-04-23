package com.example.LibrarySystem.ATMSystem.System2;

import java.util.Date;

// Enumeration
enum ATMStateEnum {
    Idle,
    HasCard,
    SelestionOption,
    Withdraw,
    TransferMoney,
    BalanceInquiry
}

class User {
    private ATMCard card;
    private BankAccount account;
}

class ATMCard {
    private String cardNumber;
    private String customerName;
    private Date cardExpiryDate;
    private int pin;
}

class Bank {
    private String name;
    private String bankCode;

    public String getBankCode();

    public boolean addATM();
}

class BankAccount {
    private int accountNumber;
    private double totalBalance;
    private double availableBalance;

    public double getAvailableBalance();
}

class SavingAccount extends BankAccount {
    public double withdrawLimit();
}

class CurrentAccount extends BankAccount {
    public double withdrawLimit();
}

class CardReader {
    public boolean readCard();
}

class CashDispenser {
    public boolean dispenseCash();
}

class Keypad {
    public String getInput();
}

class Screen {
    public void showMessage();
}

class Printer {
    public void printReceipt();
}

abstract class ATMState {

    public abstract void insertCard(ATM atm, ATMCard card);

    public abstract void authenticatePin(ATM atm, ATMCard card, int pin);

    public abstract void selectOperation(ATM atm, ATMCard card, TransactionType tType);

    public abstract void cashWithdrawal(ATM atm, ATMCard card, int withdrawAmount);

    public abstract void displayBalance(ATM atm, ATMCard card);

    public abstract void transferMoney(ATM atm, ATMCard card, int accountNumber, int transferAmount);

    public abstract void returnCard();

    public abstract void exit(ATM atm);

}

class IdleState extends ATMState {

    @Override
    public void insertCard(ATM atm, ATMCard card) {
        // definition
    }

    @Override
    public void authenticatePin(ATM atm, ATMCard card, int pin) {
        // definition
    }

    @Override
    public void selectOperation(ATM atm, ATMCard card, TransactionType tType) {
        // definition
    }

    @Override
    public void cashWithdrawal(ATM atm, ATMCard card, int withdrawAmount) {
        // definition
    }

    @Override
    public void displayBalance(ATM atm, ATMCard card) {
        // definition
    }

    @Override
    public void transferMoney(ATM atm, ATMCard card, int accountNumber, int transferAmount) {
        // definition
    }

    @Override
    public void returnCard() {
        // definition
    }

    @Override
    public void exit(ATM atm) {
        // definition
    }
}

class HasCardState extends ATMState {

    @Override
    public void insertCard(ATM atm, ATMCard card) {
        // definition
    }

    @Override
    public void authenticatePin(ATM atm, ATMCard card, int pin) {
        // definition
    }

    @Override
    public void selectOperation(ATM atm, ATMCard card, TransactionType tType) {
        // definition
    }

    @Override
    public void cashWithdrawal(ATM atm, ATMCard card, int withdrawAmount) {
        // definition
    }

    @Override
    public void displayBalance(ATM atm, ATMCard card) {
        // definition
    }

    @Override
    public void transferMoney(ATM atm, ATMCard card, int accountNumber, int transferAmount) {
        // definition
    }

    @Override
    public void returnCard() {
        // definition
    }

    @Override
    public void exit(ATM atm) {
        // definition
    }
}

class SelectOperationState extends ATMState {

    @Override
    public void insertCard(ATM atm, ATMCard card) {
        // definition
    }

    @Override
    public void authenticatePin(ATM atm, ATMCard card, int pin) {
        // definition
    }

    @Override
    public void selectOperation(ATM atm, ATMCard card, TransactionType tType) {
        // definition
    }

    @Override
    public void cashWithdrawal(ATM atm, ATMCard card, int withdrawAmount) {
        // definition
    }

    @Override
    public void displayBalance(ATM atm, ATMCard card) {
        // definition
    }

    @Override
    public void transferMoney(ATM atm, ATMCard card, int accountNumber, int transferAmount) {
        // definition
    }

    @Override
    public void returnCard() {
        // definition
    }

    @Override
    public void exit(ATM atm) {
        // definition
    }
}

class CheckBalanceState extends ATMState {

    @Override
    public void insertCard(ATM atm, ATMCard card) {
        // definition
    }

    @Override
    public void authenticatePin(ATM atm, ATMCard card, int pin) {
        // definition
    }

    @Override
    public void selectOperation(ATM atm, ATMCard card, TransactionType tType) {
        // definition
    }

    @Override
    public void cashWithdrawal(ATM atm, ATMCard card, int withdrawAmount) {
        // definition
    }

    @Override
    public void displayBalance(ATM atm, ATMCard card) {
        // definition
    }

    @Override
    public void transferMoney(ATM atm, ATMCard card, int accountNumber, int transferAmount) {
        // definition
    }

    @Override
    public void returnCard() {
        // definition
    }

    @Override
    public void exit(ATM atm) {
        // definition
    }
}

class CashWithdrawalState extends ATMState {

    @Override
    public void insertCard(ATM atm, ATMCard card) {
        // definition
    }

    @Override
    public void authenticatePin(ATM atm, ATMCard card, int pin) {
        // definition
    }

    @Override
    public void selectOperation(ATM atm, ATMCard card, TransactionType tType) {
        // definition
    }

    @Override
    public void cashWithdrawal(ATM atm, ATMCard card, int withdrawAmount) {
        // definition
    }

    @Override
    public void displayBalance(ATM atm, ATMCard card) {
        // definition
    }

    @Override
    public void transferMoney(ATM atm, ATMCard card, int accountNumber, int transferAmount) {
        // definition
    }

    @Override
    public void returnCard() {
        // definition
    }

    @Override
    public void exit(ATM atm) {
        // definition
    }
}

class TransferMoneyState extends ATMState {

    @Override
    public void insertCard(ATM atm, ATMCard card) {
        // definition
    }

    @Override
    public void authenticatePin(ATM atm, ATMCard card, int pin) {
        // definition
    }

    @Override
    public void selectOperation(ATM atm, ATMCard card, TransactionType tType) {
        // definition
    }

    @Override
    public void cashWithdrawal(ATM atm, ATMCard card, int withdrawAmount) {
        // definition
    }

    @Override
    public void displayBalance(ATM atm, ATMCard card) {
        // definition
    }

    @Override
    public void transferMoney(ATM atm, ATMCard card, int accountNumber, int transferAmount) {
        // definition
    }

    @Override
    public void returnCard() {
        // definition
    }

    @Override
    public void exit(ATM atm) {
        // definition
    }
}

class ATM {
    private static ATM atmObject = new ATM(); // Singleton
    private ATMState currentATMState;
    private int atmBalance;
    private int noOfHundredDollarBills;
    private int noOfFiftyDollarBills;
    private int noOfTenDollarBills;

    // References to various ATM components
    private CardReader cardReader;
    private CashDispenser cashDispenser;
    private Keypad keypad;
    private Screen screen;
    private Printer printer;

    public void displayCurrentState();

    public void initializeATM(int atmBalance, int noOfHundredDollarBills, int noOfFiftyDollarBills,
            int noOfTenDollarBills);
}

class ATMRoom {
    private ATM atm;
    private User user;
}

public class System2 {

}
