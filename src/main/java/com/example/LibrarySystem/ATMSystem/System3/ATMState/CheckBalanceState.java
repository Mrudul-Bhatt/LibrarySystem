package com.example.LibrarySystem.ATMSystem.System3.ATMState;

import com.example.LibrarySystem.ATMSystem.System3.ATM_ATMRoom.ATM;
import com.example.LibrarySystem.ATMSystem.System3.Enumerations.TransactionType;
import com.example.LibrarySystem.ATMSystem.System3.User_ATMCard.ATMCard;

public class CheckBalanceState extends ATMState {

    @Override
    public void insertCard(ATM atm, ATMCard card) {
        throw new UnsupportedOperationException("Unimplemented method 'insertCard'");
    }

    @Override
    public void authenticatePin(ATM atm, ATMCard card, int pin) {
        throw new UnsupportedOperationException("Unimplemented method 'authenticatePin'");
    }

    @Override
    public void selectOperation(ATM atm, ATMCard card, TransactionType tType) {
        throw new UnsupportedOperationException("Unimplemented method 'selectOperation'");
    }

    @Override
    public void cashWithdrawal(ATM atm, ATMCard card, int withdrawAmount) {
        throw new UnsupportedOperationException("Unimplemented method 'cashWithdrawal'");
    }

    @Override
    public void displayBalance(ATM atm, ATMCard card) {
        throw new UnsupportedOperationException("Unimplemented method 'displayBalance'");
    }

    @Override
    public void transferMoney(ATM atm, ATMCard card, int accountNumber, int transferAmount) {
        throw new UnsupportedOperationException("Unimplemented method 'transferMoney'");
    }

    @Override
    public void returnCard() {
        throw new UnsupportedOperationException("Unimplemented method 'returnCard'");
    }

    @Override
    public void exit(ATM atm) {
        throw new UnsupportedOperationException("Unimplemented method 'exit'");
    }

}
