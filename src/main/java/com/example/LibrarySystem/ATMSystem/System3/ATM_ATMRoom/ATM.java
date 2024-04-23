package com.example.LibrarySystem.ATMSystem.System3.ATM_ATMRoom;

import com.example.LibrarySystem.ATMSystem.System3.ATMState.ATMState;
import com.example.LibrarySystem.ATMSystem.System3.Card_ATM_Operations.CardReader;
import com.example.LibrarySystem.ATMSystem.System3.Card_ATM_Operations.CashDispenser;
import com.example.LibrarySystem.ATMSystem.System3.Card_ATM_Operations.Keypad;
import com.example.LibrarySystem.ATMSystem.System3.Card_ATM_Operations.Printer;
import com.example.LibrarySystem.ATMSystem.System3.Card_ATM_Operations.Screen;

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

    // References to various ATM components
    private CardReader cardReader;
    private CashDispenser cashDispenser;
    private Keypad keypad;
    private Screen screen;
    private Printer printer;

    public void displayCurrentState() {

    }

    public void initializeATM(int atmBalance, int noOfHundredDollarBills, int noOfFiftyDollarBills,
            int noOfTenDollarBills) {

    }
}
