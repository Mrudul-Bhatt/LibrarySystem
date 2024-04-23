package com.example.LibrarySystem.ATMSystem.System3.ATMState;

import com.example.LibrarySystem.ATMSystem.System3.ATM_ATMRoom.ATM;
import com.example.LibrarySystem.ATMSystem.System3.Bank_BankAccount.BankAccount;
import com.example.LibrarySystem.ATMSystem.System3.Enumerations.TransactionType;
import com.example.LibrarySystem.ATMSystem.System3.User_ATMCard.ATMCard;

public class TransferMoneyState extends ATMState {
    private static TransferMoneyState instance = new TransferMoneyState(); // Singleton instance

    private TransferMoneyState() {
    }

    public static TransferMoneyState getInstance() {
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
        System.out.println("Please complete the money transfer transaction first.");
    }

    @Override
    public void displayBalance(ATM atm, ATMCard card) {
        System.out.println("Please complete the money transfer transaction first.");
    }

    @Override
    public void transferMoney(ATM atm, ATMCard card, int accountNumber, int transferAmount) {
        BankAccount userAccount = atm.getCurrentUser().getAccount();
        BankAccount recipientAccount = atm.getBank().getAccounts().get(accountNumber);

        if (recipientAccount != null) {
            if (userAccount.getAvailableBalance() >= transferAmount) {
                userAccount.withdraw(transferAmount);
                recipientAccount.deposit(transferAmount);
                System.out.println("Transfer of $" + transferAmount + " to account " + accountNumber + " successful.");
                atm.setCurrentATMState(IdleState.getInstance());
                atm.getPrinter().printReceipt("Money transfer" + transferAmount);
                atm.getCardReader().ejectCard();
            } else {
                System.out.println("Insufficient funds.");
                atm.setCurrentATMState(SelectOperationState.getInstance());
            }
        } else {
            System.out.println("Recipient account not found.");
            atm.setCurrentATMState(SelectOperationState.getInstance());
        }
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
