package com.example.LibrarySystem.AirlineManagementSystem.System2.Payment;

import com.example.LibrarySystem.AirlineManagementSystem.System2.Enums.PaymentStatus;

public class Cash extends Payment {
    public Cash(int paymentId, double amount) {
        super(paymentId, amount);
    }

    // Implementation of the abstract method to process cash payment
    @Override
    public boolean makePayment() {
        // Simulate payment processing logic for cash
        System.out.println("Processing cash payment of amount: " + super.getAmount());
        // Assume payment is always successful
        setPaymentStatus(PaymentStatus.COMPLETED);
        return true;
    }
}
