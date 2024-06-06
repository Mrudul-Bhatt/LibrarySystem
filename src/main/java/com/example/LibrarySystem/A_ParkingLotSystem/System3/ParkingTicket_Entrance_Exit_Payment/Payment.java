package com.example.LibrarySystem.A_ParkingLotSystem.System3.ParkingTicket_Entrance_Exit_Payment;

import com.example.LibrarySystem.A_ParkingLotSystem.System3.Enums.PaymentStatus;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class Payment {
    private double amount;
    private PaymentStatus status;
    private Date timestamp;

    public Payment(double amount) {
        this.amount = amount;
        this.status = PaymentStatus.UNPAID;
    }

    public boolean initiateTransaction() {
        // Process the payment
        if (amount > 0) {
            this.status = PaymentStatus.COMPLETED;
            this.timestamp = new Date();
            return true;
        }
        return false;
    }
}
