package com.example.LibrarySystem.RestaurantManagementSystem.Payment_Bill;

import com.example.LibrarySystem.RestaurantManagementSystem.Enums.PaymentStatus;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public abstract class Payment {
    private int paymentID;
    private Date creationDate;
    private double amount;
    private PaymentStatus status;

    public abstract void initiateTransaction();
}
