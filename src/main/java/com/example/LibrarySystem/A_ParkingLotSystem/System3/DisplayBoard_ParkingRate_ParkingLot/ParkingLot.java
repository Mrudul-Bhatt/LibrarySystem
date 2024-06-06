package com.example.LibrarySystem.A_ParkingLotSystem.System3.DisplayBoard_ParkingRate_ParkingLot;

import com.example.LibrarySystem.A_ParkingLotSystem.System3.ParkingSpot_Handicapped_Compact_Large_Motorcycle.ParkingSpot;
import com.example.LibrarySystem.A_ParkingLotSystem.System3.ParkingTicket_Entrance_Exit_Payment.Entrance;
import com.example.LibrarySystem.A_ParkingLotSystem.System3.ParkingTicket_Entrance_Exit_Payment.Exit;
import com.example.LibrarySystem.A_ParkingLotSystem.System3.ParkingTicket_Entrance_Exit_Payment.ParkingTicket;
import com.example.LibrarySystem.A_ParkingLotSystem.System3.Vehicle_Car_Van_Truck_Motorcycle.Vehicle;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.UUID;

@Getter
@Setter
public class ParkingLot {
    // The ParkingLot is a singleton class that ensures it will have only one active instance at a time
    // Both the Entrance and Exit classes use this class to create and close parking tickets
    private static ParkingLot parkingLot = null;
    private int id;
    private String name;
    private String address;
    private ParkingRate parkingRate;
    private HashMap<String, Entrance> entrances;
    private HashMap<String, Exit> exits;
    // Create a hashmap that identifies all currently generated tickets using their ticket number
    private HashMap<Integer, ParkingTicket> tickets;
    private DisplayBoard displayBoard;

    // Created a private constructor to add a restriction (due to Singleton)
    private ParkingLot() {
        entrances = new HashMap<>();
        exits = new HashMap<>();
        tickets = new HashMap<>();
        parkingRate = new ParkingRate();
        displayBoard = new DisplayBoard(UUID.randomUUID());
    }

    // Created a static method to access the singleton instance of ParkingLot
    public static ParkingLot getInstance() {
        if (parkingLot == null) {
            parkingLot = new ParkingLot();
        }
        return parkingLot;
    }

    public void addEntrance(Entrance entrance) {
        entrances.put(String.valueOf(entrance.getId()), entrance);
    }

    public void addExit(Exit exit) {
        exits.put(String.valueOf(exit.getId()), exit);
    }

    // This function allows parking tickets to be available at multiple entrances
    public ParkingTicket getParkingTicket(Vehicle vehicle) {
        Entrance entrance = entrances.values().iterator().next(); // Get the first entrance for simplicity
        return entrance.getTicket(vehicle);
    }

    public boolean isFull(Class<? extends ParkingSpot> spotType) {
        return displayBoard != null && displayBoard.getParkingSpots().get(spotType.getSimpleName())
                .stream().noneMatch(ParkingSpot::isFree);
    }

    public void addTicket(ParkingTicket ticket) {
        tickets.put(ticket.getTicketNo(), ticket);
    }

    public void removeTicket(ParkingTicket ticket) {
        tickets.remove(ticket.getTicketNo());
    }
}
