package com.example.LibrarySystem.ATMSystem.System3.ATMState;

import com.example.LibrarySystem.ATMSystem.System3.ATM_ATMRoom.ATM;
import com.example.LibrarySystem.ATMSystem.System3.Enumerations.TransactionType;
import com.example.LibrarySystem.ATMSystem.System3.User_ATMCard.ATMCard;

public class CheckBalanceState extends ATMState {
    private static CheckBalanceState instance = new CheckBalanceState(); // Singleton instance

    private CheckBalanceState() {
    }

    public static CheckBalanceState getInstance() {
        return instance;
    }

    @Override
    public void insertCard(ATM atm, ATMCard card) {
        System.out.println("Card already inserted.");
    }

    @Override
    public void authenticatePin(ATM atm, ATMCard card, int pin) {
        System.out.println("PIN already authenticated.");
    }

    @Override
    public void selectOperation(ATM atm, ATMCard card, TransactionType tType) {
        System.out.println("Operation already selected.");
    }

    @Override
    public void cashWithdrawal(ATM atm, ATMCard card, int withdrawAmount) {
        System.out.println("Please complete the balance inquiry transaction first.");
    }

    @Override
    public void displayBalance(ATM atm, ATMCard card) {
        System.out.println("Available Balance: $" + atm.getCurrentUser().getAccount().getAvailableBalance());
        atm.setCurrentATMState(IdleState.getInstance());
        atm.getPrinter().printReceipt("Balance inquiry" + atm.getCurrentUser().getAccount().getAvailableBalance());
        atm.getCardReader().ejectCard();
    }

    @Override
    public void transferMoney(ATM atm, ATMCard card, int accountNumber, int transferAmount) {
        System.out.println("Please complete the balance inquiry transaction first.");
    }

    @Override
    public void returnCard(ATM atm) {
        System.out.println("Card returned.");
        atm.setCurrentATMState(IdleState.getInstance());
    }

    @Override
    public void exit(ATM atm) {
        System.out.println("ATM session terminated.");
        atm.setCurrentATMState(IdleState.getInstance());
    }

}
