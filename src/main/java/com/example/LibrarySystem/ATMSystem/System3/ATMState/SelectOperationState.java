package com.example.LibrarySystem.ATMSystem.System3.ATMState;

import com.example.LibrarySystem.ATMSystem.System3.ATM_ATMRoom.ATM;
import com.example.LibrarySystem.ATMSystem.System3.Enumerations.TransactionType;
import com.example.LibrarySystem.ATMSystem.System3.User_ATMCard.ATMCard;

public class SelectOperationState extends ATMState {
    private static SelectOperationState instance = new SelectOperationState(); // Singleton instance

    private SelectOperationState() {
    }

    public static SelectOperationState getInstance() {
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
        switch (tType) {
            case CASH_WITHDRAWAL:
                atm.setCurrentATMState(CashWithdrawalState.getInstance());
                break;
            case BALANCE_INQUIRY:
                atm.setCurrentATMState(CheckBalanceState.getInstance());
                break;
            case TRANSFER_MONEY:
                atm.setCurrentATMState(TransferMoneyState.getInstance());
                break;
            default:
                System.out.println("Invalid transaction type.");
                break;
        }
    }

    @Override
    public void cashWithdrawal(ATM atm, ATMCard card, int withdrawAmount) {
        System.out.println("Please select an operation.");
    }

    @Override
    public void displayBalance(ATM atm, ATMCard card) {
        System.out.println("Please select an operation.");
    }

    @Override
    public void transferMoney(ATM atm, ATMCard card, int accountNumber, int transferAmount) {
        System.out.println("Please select an operation.");
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
