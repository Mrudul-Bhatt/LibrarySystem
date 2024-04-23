package com.example.LibrarySystem.ATMSystem.System3.ATM_ATMRoom;

import com.example.LibrarySystem.ATMSystem.System3.ATMState.ATMState;
import com.example.LibrarySystem.ATMSystem.System3.ATMState.IdleState;
import com.example.LibrarySystem.ATMSystem.System3.Bank_BankAccount.Bank;
import com.example.LibrarySystem.ATMSystem.System3.Card_ATM_Operations.CardReader;
import com.example.LibrarySystem.ATMSystem.System3.Card_ATM_Operations.CashDispenser;
import com.example.LibrarySystem.ATMSystem.System3.Card_ATM_Operations.Keypad;
import com.example.LibrarySystem.ATMSystem.System3.Card_ATM_Operations.Printer;
import com.example.LibrarySystem.ATMSystem.System3.Card_ATM_Operations.Screen;
import com.example.LibrarySystem.ATMSystem.System3.Enumerations.TransactionType;
import com.example.LibrarySystem.ATMSystem.System3.User_ATMCard.ATMCard;
import com.example.LibrarySystem.ATMSystem.System3.User_ATMCard.User;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ATM {
    private static ATM atmObject = new ATM(); // Singleton
    private ATMState currentATMState;
    private int atmBalance;
    private int noOfHundredDollarBills;
    private int noOfFiftyDollarBills;
    private int noOfTenDollarBills;

    // Current user using ATM
    private User currentUser;

    // Which bank does this ATM belongs to ?
    private Bank bank;

    // References to various ATM components
    private CardReader cardReader;
    private CashDispenser cashDispenser;
    private Keypad keypad;
    private Screen screen;
    private Printer printer;

    public ATM() {
        this.currentATMState = IdleState.getInstance();
        this.cardReader = new CardReader();
        this.cashDispenser = new CashDispenser();
        this.keypad = new Keypad();
        this.screen = new Screen();
        this.printer = new Printer();
    }

    // Methods to simulate ATM operations (State Desing Pattern)
    public void insertCard(ATMCard card) {
        currentATMState.insertCard(this, card);
    }

    public void authenticatePin(int pin) {
        currentATMState.authenticatePin(this, currentUser.getCard(), pin);
    }

    public void selectOperation(TransactionType tType) {
        currentATMState.selectOperation(this, currentUser.getCard(), tType);
    }

    public void cashWithdrawal(int withdrawAmount) {
        currentATMState.cashWithdrawal(this, currentUser.getCard(), withdrawAmount);
    }

    public void displayBalance() {
        currentATMState.displayBalance(this, currentUser.getCard());
    }

    public void transferMoney(int accountNumber, int transferAmount) {
        currentATMState.transferMoney(this, currentUser.getCard(), accountNumber, transferAmount);
    }

    public void returnCard() {
        currentATMState.returnCard(this);
    }

    public void exit() {
        currentATMState.exit(this);
    }

}
