package com.example.LibrarySystem.AirlineManagementSystem.System2.Payment;

import com.example.LibrarySystem.AirlineManagementSystem.System2.Enums.PaymentStatus;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public abstract class Payment {
    private int paymentId;
    private double amount;
    private PaymentStatus status;
    private Date timestamp;

    public Payment(int paymentId, double amount) {
        this.paymentId = paymentId;
        this.amount = amount;
        this.status = PaymentStatus.PENDING;
        this.timestamp = new Date();
    }

    // Abstract method to make payment, to be implemented by subclasses
    public abstract boolean makePayment();

    // Check if the payment was successful
    public boolean isPaymentSuccessful() {
        return this.status == PaymentStatus.COMPLETED;
    }

    // Set payment status
    protected void setPaymentStatus(PaymentStatus status) {
        this.status = status;
    }
}
