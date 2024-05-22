package com.example.LibrarySystem.AirlineManagementSystem.System2.Payment;

import com.example.LibrarySystem.AirlineManagementSystem.System2.Enums.PaymentStatus;

import java.util.Date;

public abstract class Payment {
    private int paymentId;
    private double amount;
    private PaymentStatus status;
    private Date timestamp;

    public abstract boolean makePayment();
}
