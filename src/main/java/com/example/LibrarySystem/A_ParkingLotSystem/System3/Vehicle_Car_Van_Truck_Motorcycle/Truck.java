package com.example.LibrarySystem.A_ParkingLotSystem.System3.Vehicle_Car_Van_Truck_Motorcycle;

import com.example.LibrarySystem.A_ParkingLotSystem.System3.ParkingTicket_Entrance_Exit_Payment.ParkingTicket;

public class Truck extends Vehicle {
    public Truck(String licensePlate) {
        super(licensePlate);
    }

    @Override
    public void assignTicket(ParkingTicket ticket) {
        setTicket(ticket);
    }
}
