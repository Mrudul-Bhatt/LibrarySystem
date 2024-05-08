package com.example.LibrarySystem.HotelManagementSystem.System3.BillTransaction;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreditCardTransaction extends BillTransaction {
    private String nameOnCard;
    private String creditCardNumber;

    public CreditCardTransaction(double amount, String creditCardNumber) {
        super(amount);
        this.creditCardNumber = creditCardNumber;
    }

    @Override
    public void initiateTransaction() {
        // Logic to initiate a credit card transaction
        // This method could involve updating the payment status, processing the credit
        // card payment, etc.
    }
}
