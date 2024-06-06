package com.example.LibrarySystem.A_ParkingLotSystem.System3.ParkingTicket_Entrance_Exit_Payment;

import com.example.LibrarySystem.A_ParkingLotSystem.System3.DisplayBoard_ParkingRate_ParkingLot.ParkingLot;
import com.example.LibrarySystem.A_ParkingLotSystem.System3.DisplayBoard_ParkingRate_ParkingLot.ParkingRate;
import com.example.LibrarySystem.A_ParkingLotSystem.System3.Vehicle_Car_Van_Truck_Motorcycle.Vehicle;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class ParkingTicket {
    private int ticketNo;
    private Date timestamp;
    private Date exit;
    private double amount;
    private boolean ticketStatus;

    // Following are the instances of their respective classes
    private Vehicle vehicle;
    private Payment payment;
    private Entrance entrance;
    private Exit exitIns;

    public double calculateAmount() {
        if (exit == null || timestamp == null) {
            return 0.0;
        }

        long duration = exit.getTime() - timestamp.getTime();
        double hours = (double) duration / (1000 * 60 * 60);
        ParkingRate rate = ParkingLot.getInstance().getParkingRate();
        return hours * rate.getRate();
    }

    public boolean getStatus() {
        return this.ticketStatus;
    }

    public void setStatus(boolean status) {
        ticketStatus = status;
    }
}
