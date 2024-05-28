package com.example.LibrarySystem.A_ParkingLotSystem.System3.ParkingTicket_Entrance_Exit_Payment;

import com.example.LibrarySystem.A_ParkingLotSystem.System3.Vehicle_Car_Van_Truck_Motorcycle.Vehicle;

import java.util.Date;

public class ParkingTicket {
    private int ticketNo;
    private Date timestamp;
    private Date exit;
    private double amount;
    private boolean status;

    // Following are the instances of their respective classes
    private Vehicle vehicle;
    private Payment payment;
    private Entrance entrance;
    private Exit exitIns;
}
