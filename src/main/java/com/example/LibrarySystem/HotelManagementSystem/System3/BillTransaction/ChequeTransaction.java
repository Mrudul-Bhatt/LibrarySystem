package com.example.LibrarySystem.HotelManagementSystem.System3.BillTransaction;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ChequeTransaction extends BillTransaction {
    private String bankName;
    private String chequeNumber;

    public ChequeTransaction(double amount, String chequeNumber) {
        super(amount);
        this.chequeNumber = chequeNumber;
    }

    @Override
    public void initiateTransaction() {
        // Logic to initiate a cheque transaction
        // This method could involve updating the payment status, processing the cheque,
        // etc.
    }
}
