package com.example.LibrarySystem.ATMSystem.System3.ATMState;

import com.example.LibrarySystem.ATMSystem.System3.ATM_ATMRoom.ATM;
import com.example.LibrarySystem.ATMSystem.System3.Enumerations.TransactionType;
import com.example.LibrarySystem.ATMSystem.System3.User_ATMCard.ATMCard;

public abstract class ATMState {
    public abstract void insertCard(ATM atm, ATMCard card);

    public abstract void authenticatePin(ATM atm, ATMCard card, int pin);

    public abstract void selectOperation(ATM atm, ATMCard card, TransactionType tType);

    public abstract void cashWithdrawal(ATM atm, ATMCard card, int withdrawAmount);

    public abstract void displayBalance(ATM atm, ATMCard card);

    public abstract void transferMoney(ATM atm, ATMCard card, int accountNumber, int transferAmount);

    public abstract void returnCard(ATM atm);

    public abstract void exit(ATM atm);
}
