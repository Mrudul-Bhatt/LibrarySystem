package com.example.LibrarySystem.A_ParkingLotSystem.System3.Vehicle_Car_Van_Truck_Motorcycle;

import com.example.LibrarySystem.A_ParkingLotSystem.System3.ParkingTicket_Entrance_Exit_Payment.ParkingTicket;

public abstract class Vehicle {
    private int licenseNo;

    public abstract void assignTicket(ParkingTicket ticket);
}
