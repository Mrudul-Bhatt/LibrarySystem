package com.example.LibrarySystem.ATMSystem.System3.ATMState;

import com.example.LibrarySystem.ATMSystem.System3.ATM_ATMRoom.ATM;
import com.example.LibrarySystem.ATMSystem.System3.Bank_BankAccount.BankAccount;
import com.example.LibrarySystem.ATMSystem.System3.Enumerations.TransactionType;
import com.example.LibrarySystem.ATMSystem.System3.User_ATMCard.ATMCard;

public class CashWithdrawalState extends ATMState {
    private static CashWithdrawalState instance = new CashWithdrawalState(); // Singleton instance

    private CashWithdrawalState() {
    }

    public static CashWithdrawalState getInstance() {
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
        BankAccount bankAccount = atm.getCurrentUser().getAccount();
        if (bankAccount.getAvailableBalance() >= withdrawAmount) {
            System.out.println("Cash withdrawal of $" + withdrawAmount + " successful.");
            bankAccount.withdraw(withdrawAmount);
            atm.setCurrentATMState(IdleState.getInstance());
            atm.getCashDispenser().dispenseCash(withdrawAmount); // Dispense cash
            atm.getPrinter().printReceipt("Cash withdrawal" + withdrawAmount);
            atm.getCardReader().ejectCard();
        } else {
            System.out.println("Insufficient funds.");
            atm.setCurrentATMState(SelectOperationState.getInstance());
        }
    }

    @Override
    public void displayBalance(ATM atm, ATMCard card) {
        System.out.println("Please complete the cash withdrawal transaction first.");
    }

    @Override
    public void transferMoney(ATM atm, ATMCard card, int accountNumber, int transferAmount) {
        System.out.println("Please complete the cash withdrawal transaction first.");
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
