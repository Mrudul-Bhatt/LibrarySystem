package com.example.LibrarySystem.A_ParkingLotSystem.System3;

import com.example.LibrarySystem.A_ParkingLotSystem.System3.Account_Admin_ParkingAttendant.Admin;
import com.example.LibrarySystem.A_ParkingLotSystem.System3.Account_Admin_ParkingAttendant.ParkingAttendant;
import com.example.LibrarySystem.A_ParkingLotSystem.System3.DisplayBoard_ParkingRate_ParkingLot.DisplayBoard;
import com.example.LibrarySystem.A_ParkingLotSystem.System3.DisplayBoard_ParkingRate_ParkingLot.ParkingLot;
import com.example.LibrarySystem.A_ParkingLotSystem.System3.Enums.AccountStatus;
import com.example.LibrarySystem.A_ParkingLotSystem.System3.ParkingSpot_Handicapped_Compact_Large_Motorcycle.*;
import com.example.LibrarySystem.A_ParkingLotSystem.System3.ParkingTicket_Entrance_Exit_Payment.Entrance;
import com.example.LibrarySystem.A_ParkingLotSystem.System3.ParkingTicket_Entrance_Exit_Payment.Exit;
import com.example.LibrarySystem.A_ParkingLotSystem.System3.ParkingTicket_Entrance_Exit_Payment.ParkingTicket;
import com.example.LibrarySystem.A_ParkingLotSystem.System3.Person_Address.Person;
import com.example.LibrarySystem.A_ParkingLotSystem.System3.Vehicle_Car_Van_Truck_Motorcycle.Car;
import com.example.LibrarySystem.A_ParkingLotSystem.System3.Vehicle_Car_Van_Truck_Motorcycle.Vehicle;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Main {
    public static void main(String[] args) {
        // Create ParkingLot instance
        ParkingLot parkingLot = ParkingLot.getInstance();

        // Create Admin and ParkingAttendant accounts
        Person adminPerson = new Person("AName", "AAddress", "APhone", "AEmail");
        Admin admin = new Admin("adminUser", "adminPass", adminPerson, AccountStatus.ACTIVE);

        Person attendantPerson = new Person("AttName", "AttAddress", "AttPhone", "AttEmail");
        ParkingAttendant attendant = new ParkingAttendant("attendantUser", "attendantPass",
                attendantPerson, AccountStatus.ACTIVE);

        // Add Entrance
        Entrance entrance1 = new Entrance(1);
        admin.addEntrance(entrance1);

        // Add Exit
        Exit exit1 = new Exit(1);
        admin.addExit(exit1);

        // Add Display Board
        DisplayBoard displayBoard = new DisplayBoard(UUID.randomUUID());
        admin.addDisplayBoard(displayBoard);

        // Add Parking Spots
        List<ParkingSpot> compactSpots = new ArrayList<>();
        compactSpots.add(new CompactSpot(1));
        compactSpots.add(new CompactSpot(2));
        admin.addParkingSpot(compactSpots.get(0));
        admin.addParkingSpot(compactSpots.get(1));

        List<ParkingSpot> largeSpots = new ArrayList<>();
        largeSpots.add(new LargeSpot(3));
        largeSpots.add(new LargeSpot(4));
        admin.addParkingSpot(largeSpots.get(0));
        admin.addParkingSpot(largeSpots.get(1));

        List<ParkingSpot> handicappedSpots = new ArrayList<>();
        handicappedSpots.add(new HandicappedSpot(5));
        handicappedSpots.add(new HandicappedSpot(6));
        admin.addParkingSpot(handicappedSpots.get(0));
        admin.addParkingSpot(handicappedSpots.get(1));

        List<ParkingSpot> motorcycleSpots = new ArrayList<>();
        motorcycleSpots.add(new MotorcycleSpot(7));
        motorcycleSpots.add(new MotorcycleSpot(8));
        admin.addParkingSpot(motorcycleSpots.get(0));
        admin.addParkingSpot(motorcycleSpots.get(1));

        // Simulate a vehicle entering and getting a parking ticket
        Vehicle car = new Car("ABC123");
        ParkingTicket ticket = entrance1.getTicket(car);
        System.out.println("Parking ticket issued: " + ticket.getTicketNo());

        // Display available parking spots
        displayBoard.showFreeSlot();

        // Simulate the vehicle exiting and processing the ticket
        boolean processed = attendant.processTicket(String.valueOf(ticket.getTicketNo()));
        System.out.println("Ticket processed: " + processed);

        // Display available parking spots after vehicle exits
        displayBoard.showFreeSlot();
    }
}
