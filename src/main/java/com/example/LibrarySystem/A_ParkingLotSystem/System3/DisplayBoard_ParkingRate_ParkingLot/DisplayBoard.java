package com.example.LibrarySystem.A_ParkingLotSystem.System3.DisplayBoard_ParkingRate_ParkingLot;

import com.example.LibrarySystem.A_ParkingLotSystem.System3.ParkingSpot_Handicapped_Compact_Large_Motorcycle.ParkingSpot;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Getter
@Setter
public class DisplayBoard {
    private UUID id;
    private Map<String, List<ParkingSpot>> parkingSpots;

    public DisplayBoard(UUID id) {
        this.id = id;
        this.parkingSpots = new HashMap<>();
    }

    public void addParkingSpot(String spotType, List<ParkingSpot> spots) {
        parkingSpots.put(spotType, spots);
    }

    public void showFreeSlot() {
        for (Map.Entry<String, List<ParkingSpot>> entry : parkingSpots.entrySet()) {
            String spotType = entry.getKey();
            List<ParkingSpot> spots = entry.getValue();
            long freeSpots = spots.stream().filter(ParkingSpot::isFree).count();
            System.out.println("Free " + spotType + " spots: " + freeSpots);
        }
    }
}
