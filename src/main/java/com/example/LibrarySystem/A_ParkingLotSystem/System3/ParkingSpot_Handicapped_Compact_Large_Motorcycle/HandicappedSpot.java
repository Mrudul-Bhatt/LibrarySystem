package com.example.LibrarySystem.A_ParkingLotSystem.System3.ParkingSpot_Handicapped_Compact_Large_Motorcycle;

import com.example.LibrarySystem.A_ParkingLotSystem.System3.Vehicle_Car_Van_Truck_Motorcycle.Vehicle;

public class HandicappedSpot extends ParkingSpot {

    public HandicappedSpot(int id) {
        super(id);
    }

    @Override
    public boolean canFitVehicle(Vehicle vehicle) {
        return true;  // All types of vehicles can park in handicapped spots.
    }

    @Override
    public boolean assignVehicle(Vehicle vehicle) {
        if (canFitVehicle(vehicle)) {
            return super.assignVehicle(vehicle);
        }
        return false;
    }
}
