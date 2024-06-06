package com.example.LibrarySystem.A_ParkingLotSystem.System3.ParkingTicket_Entrance_Exit_Payment;

import com.example.LibrarySystem.A_ParkingLotSystem.System3.DisplayBoard_ParkingRate_ParkingLot.ParkingLot;
import com.example.LibrarySystem.A_ParkingLotSystem.System3.Vehicle_Car_Van_Truck_Motorcycle.Vehicle;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class Entrance {
    private int id;

    public Entrance(int id) {
        this.id = id;
    }

    public ParkingTicket getTicket(Vehicle vehicle) {
        ParkingTicket ticket = new ParkingTicket();
        ticket.setTicketNo(generateTicketNumber());
        ticket.setTimestamp(new Date());
        ticket.setVehicle(vehicle);
        ticket.setEntrance(this);
        vehicle.assignTicket(ticket);

        ParkingLot parkingLot = ParkingLot.getInstance();
        parkingLot.addTicket(ticket);

        return ticket;
    }

    private int generateTicketNumber() {
        // Generate a unique ticket number (for simplicity using current timestamp)
        return (int) (System.currentTimeMillis() & 0xfffffff);
    }
}
