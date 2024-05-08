package com.example.LibrarySystem.AmazonOnlineShoppingSystem.System2.Payment;

import com.example.LibrarySystem.AmazonOnlineShoppingSystem.System2.Enums.PaymentStatus;

import java.util.Date;

public abstract class Payment {
    private double amount;
    private Date timestamp;
    private PaymentStatus status;

    public abstract PaymentStatus makePayment();
}
