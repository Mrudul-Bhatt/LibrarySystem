package com.example.LibrarySystem.HotelManagementSystem.System3.BillTransaction;

import com.example.LibrarySystem.HotelManagementSystem.System3.Enums.PaymentStatus;

import java.util.Date;

public abstract class BillTransaction {
    private Date creationDate;
    private double amount;
    private PaymentStatus status;

    public abstract void initiateTransaction();
}
