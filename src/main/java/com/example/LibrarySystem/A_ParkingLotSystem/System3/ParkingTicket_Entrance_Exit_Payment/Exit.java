package com.example.LibrarySystem.A_ParkingLotSystem.System3.ParkingTicket_Entrance_Exit_Payment;

import com.example.LibrarySystem.A_ParkingLotSystem.System3.DisplayBoard_ParkingRate_ParkingLot.ParkingLot;
import com.example.LibrarySystem.A_ParkingLotSystem.System3.DisplayBoard_ParkingRate_ParkingLot.ParkingRate;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class Exit {
    private int id;

    public Exit(int id) {
        this.id = id;
    }

    public void validateTicket(ParkingTicket ticket) {
        // Validate the ticket
        if (ticket == null) {
            throw new IllegalArgumentException("Invalid ticket");
        }

        ticket.setExit(new Date());
        calculateParkingCharges(ticket);

        // Process payment
        Payment payment = new Payment(ticket.calculateAmount());
        payment.initiateTransaction();

        ticket.setPayment(payment);
        ticket.setStatus(true);

        ParkingLot parkingLot = ParkingLot.getInstance();
        parkingLot.removeTicket(ticket);
    }

    private void calculateParkingCharges(ParkingTicket ticket) {
        // Calculate the parking charges
        long duration = ticket.getExit().getTime() - ticket.getTimestamp().getTime();
        double hours = (double) duration / (1000 * 60 * 60);

        ParkingRate rate = ParkingLot.getInstance().getParkingRate();
        ticket.setAmount(hours * rate.getRate());
    }
}
