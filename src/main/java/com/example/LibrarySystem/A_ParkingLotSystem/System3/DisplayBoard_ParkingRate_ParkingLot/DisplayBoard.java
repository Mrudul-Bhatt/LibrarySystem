package com.example.LibrarySystem.A_ParkingLotSystem.System3.DisplayBoard_ParkingRate_ParkingLot;

import com.example.LibrarySystem.A_ParkingLotSystem.System3.ParkingSpot_Handicapped_Compact_Large_Motorcycle.ParkingSpot;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DisplayBoard {
    private int id;
    private Map<String, List<ParkingSpot>> parkingSpots;

    // Constructor
    public DisplayBoard(int id) {
        this.id = id;
        this.parkingSpots = new HashMap<>();
    }

    // Member function
    public void addParkingSpot(String spotType, List<ParkingSpot> spots);

    public void showFreeSlot();
}
