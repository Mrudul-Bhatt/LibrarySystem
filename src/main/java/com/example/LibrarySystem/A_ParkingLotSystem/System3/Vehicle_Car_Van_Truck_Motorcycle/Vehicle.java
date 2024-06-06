package com.example.LibrarySystem.A_ParkingLotSystem.System3.Vehicle_Car_Van_Truck_Motorcycle;

import com.example.LibrarySystem.A_ParkingLotSystem.System3.ParkingTicket_Entrance_Exit_Payment.ParkingTicket;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Vehicle {
    private String licensePlate;
    private ParkingTicket ticket;

    public Vehicle(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public abstract void assignTicket(ParkingTicket ticket);
}
