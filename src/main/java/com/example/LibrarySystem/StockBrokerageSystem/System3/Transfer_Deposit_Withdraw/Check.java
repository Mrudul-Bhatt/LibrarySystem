package com.example.LibrarySystem.StockBrokerageSystem.System3.Transfer_Deposit_Withdraw;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Check extends TransferMoney {
    private String checkNumber;

    public Check(int fromAccount, int toAccount, double amount, String checkNumber) {
        super(fromAccount, toAccount, amount);
        this.checkNumber = checkNumber;
    }

    // Method to verify the check number
    public boolean verifyCheckNumber() {
        // Placeholder for actual check number verification logic
        return checkNumber != null && !checkNumber.isEmpty();
    }

    // Override method to initiate the transaction
    @Override
    public boolean initiateTransaction() {
        if (!verifyCheckNumber()) {
            return false; // Check number verification failed
        }
        if (!validateTransaction()) {
            return false; // Basic transaction validation failed
        }
        // Placeholder for actual transaction initiation logic
        // For example, update account balances, record transaction, etc.
        System.out.println("Check transaction initiated.");
        return true;
    }
}
