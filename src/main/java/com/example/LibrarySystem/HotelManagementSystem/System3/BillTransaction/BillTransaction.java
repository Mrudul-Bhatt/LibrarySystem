package com.example.LibrarySystem.HotelManagementSystem.System3.BillTransaction;

import com.example.LibrarySystem.HotelManagementSystem.System3.Enums.PaymentStatus;
import com.example.LibrarySystem.HotelManagementSystem.System3.RoomBooking_Invoice.Invoice;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public abstract class BillTransaction {
    private Date creationDate;
    private double amount;
    private PaymentStatus status;
    private Invoice invoice;

    public BillTransaction(double amount) {
        this.creationDate = new Date();
        this.amount = amount;
        this.status = PaymentStatus.PENDING; // Assume the transaction status is initially pending
    }

    public abstract void initiateTransaction();
}
