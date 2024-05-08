package com.example.LibrarySystem.HotelManagementSystem.System3.BillTransaction;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CashTransaction extends BillTransaction {
    private double cashTendered;

    public CashTransaction(double amount) {
        super(amount);
    }

    @Override
    public void initiateTransaction() {
        // Logic to initiate a cash transaction
        // This method could involve updating the payment status, generating a receipt,
        // etc.
    }
}
