package com.example.LibrarySystem.ATMSystem.System3.ATMState;

import com.example.LibrarySystem.ATMSystem.System3.ATM_ATMRoom.ATM;
import com.example.LibrarySystem.ATMSystem.System3.Enumerations.TransactionType;
import com.example.LibrarySystem.ATMSystem.System3.User_ATMCard.ATMCard;

public class IdleState extends ATMState {
    private static IdleState instance = new IdleState(); // Singleton instance

    private IdleState() {
    }

    public static IdleState getInstance() {
        return instance;
    }

    @Override
    public void insertCard(ATM atm, ATMCard card) {
        System.out.println("Card inserted. Please enter your PIN.");
        atm.setCurrentATMState(HasCardState.getInstance());
    }

    @Override
    public void authenticatePin(ATM atm, ATMCard card, int pin) {
        System.out.println("Please insert your card first.");
    }

    @Override
    public void selectOperation(ATM atm, ATMCard card, TransactionType tType) {
        System.out.println("Please insert your card first.");
    }

    @Override
    public void cashWithdrawal(ATM atm, ATMCard card, int withdrawAmount) {
        System.out.println("Please insert your card first.");
    }

    @Override
    public void displayBalance(ATM atm, ATMCard card) {
        System.out.println("Please insert your card first.");
    }

    @Override
    public void transferMoney(ATM atm, ATMCard card, int accountNumber, int transferAmount) {
        System.out.println("Please insert your card first.");
    }

    @Override
    public void returnCard(ATM atm) {
        System.out.println("No card to return.");
    }

    @Override
    public void exit(ATM atm) {
        System.out.println("ATM session terminated.");
    }

}
