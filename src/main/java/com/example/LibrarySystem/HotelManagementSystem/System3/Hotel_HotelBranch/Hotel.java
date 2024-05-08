package com.example.LibrarySystem.HotelManagementSystem.System3.Hotel_HotelBranch;

import java.util.ArrayList;
import java.util.List;

import com.example.LibrarySystem.HotelManagementSystem.System3.BillTransaction.BillTransaction;
import com.example.LibrarySystem.HotelManagementSystem.System3.Enums.RoomStyle;
import com.example.LibrarySystem.HotelManagementSystem.System3.RoomBooking_Invoice.RoomBooking;
import com.example.LibrarySystem.HotelManagementSystem.System3.Room_RoomKey_RoomHousekeeping.Room;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Hotel {
    private String name;
    private List<HotelBranch> branchLocations;
    private List<BillTransaction> transactions;

    private static Hotel instance;

    private Hotel(String name) {
        this.name = name;
        this.branchLocations = new ArrayList<>();
        this.transactions = new ArrayList<>();
    }

    public static Hotel getInstance() {
        if (instance == null) {
            instance = new Hotel("Hotel Name"); // Default hotel name
        }
        return instance;
    }

    public boolean addBranchLocation(HotelBranch branchLocation) {
        // Logic to add a location (hotel branch) to the hotel
        // This method could involve checking if the location already exists, adding the
        // location to the list, etc.
        if (!branchLocations.contains(branchLocation)) {
            branchLocations.add(branchLocation);
            return true;
        }
        return false; // Location already exists in the hotel
    }

    public Room findAvailableRoom(RoomStyle roomStyle, String hotelBranchName) {
        // Iterate through all hotel branches to find the specified branch by name
        for (HotelBranch branch : branchLocations) {
            if (branch.getName().equals(hotelBranchName)) {
                // Found the specified branch, now search for an available room of the given
                // style
                List<Room> rooms = branch.getRooms();
                for (Room room : rooms) {
                    if (room.getStyle() == roomStyle && room.isRoomAvailable()) {
                        return room; // Return the first available room of the specified style
                    }
                }
            }
        }
        return null; // No available room of the specified style found in the specified branch
    }

    public boolean makePayment(RoomBooking roomBooking, BillTransaction billTransaction) {
        transactions.add(billTransaction);
        System.out.println("Transaction completed");
        return true;
    }
}
