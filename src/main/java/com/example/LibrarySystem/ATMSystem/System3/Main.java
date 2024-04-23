package com.example.LibrarySystem.ATMSystem.System3;

import com.example.LibrarySystem.ATMSystem.System3.ATM_ATMRoom.ATM;
import com.example.LibrarySystem.ATMSystem.System3.ATM_ATMRoom.ATMRoom;
import com.example.LibrarySystem.ATMSystem.System3.Bank_BankAccount.Bank;
import com.example.LibrarySystem.ATMSystem.System3.Bank_BankAccount.BankAccount;
import com.example.LibrarySystem.ATMSystem.System3.Enumerations.TransactionType;
import com.example.LibrarySystem.ATMSystem.System3.User_ATMCard.ATMCard;
import com.example.LibrarySystem.ATMSystem.System3.User_ATMCard.User;

public class Main {
    public static void main(String[] args) {
        // Create a bank
        Bank bank = new Bank("MyBank", "MB");

        // Add some accounts to the bank
        BankAccount account1 = new BankAccount(123456789, 1000.0, 1000.0, 1234); // Account 1
        BankAccount account2 = new BankAccount(987654321, 2000.0, 2000.0, 4321); // Account 2
        bank.addAccount("1111222233334444", account1); // Add account 1
        bank.addAccount("4444333322221111", account2); // Add account 2

        // Create an ATM
        ATM atm = new ATM();
        atm.setBank(bank); // Set the bank for the ATM

        // Simulate a user inserting a card and performing transactions
        ATMCard card = new ATMCard("1111222233334444", "John Doe", new Date(), 1234); // Card for account 1
        User user = new User(card, account1); // User with card and account

        // Set the user and ATM for the ATMRoom
        ATMRoom atmRoom = new ATMRoom();
        atmRoom.setUser(user);
        atmRoom.setAtm(atm);

        // Simulate the user inserting the card into the ATM
        atm.insertCard(card);

        // Simulate the user authenticating their PIN
        atm.authenticatePin(1234);

        // Simulate the user selecting a cash withdrawal operation
        atm.selectOperation(TransactionType.CASH_WITHDRAWAL);

        // Simulate the user withdrawing cash
        atm.cashWithdrawal(500);

        // Simulate the user selecting a balance inquiry operation
        atm.selectOperation(TransactionType.BALANCE_INQUIRY);

        // Simulate the user checking their balance
        atm.displayBalance();

        // Simulate the user selecting a money transfer operation
        atm.selectOperation(TransactionType.TRANSFER_MONEY);

        // Simulate the user transferring money
        atm.transferMoney(987654321, 200);

        // Simulate the user exiting the ATM
        atm.exit();
    }
}
