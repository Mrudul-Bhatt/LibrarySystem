package com.example.LibrarySystem.A_ParkingLotSystem.System3.ParkingTicket_Entrance_Exit_Payment;

import com.example.LibrarySystem.A_ParkingLotSystem.System3.Enums.PaymentStatus;

import java.util.Date;

public class Payment {
    private double amount;
    private PaymentStatus status;
    private Date timestamp;

    public boolean initiateTransaction();
}
