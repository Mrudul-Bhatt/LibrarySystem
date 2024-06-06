package com.example.LibrarySystem.A_ParkingLotSystem.System3.ParkingSpot_Handicapped_Compact_Large_Motorcycle;

import com.example.LibrarySystem.A_ParkingLotSystem.System3.Vehicle_Car_Van_Truck_Motorcycle.Motorcycle;
import com.example.LibrarySystem.A_ParkingLotSystem.System3.Vehicle_Car_Van_Truck_Motorcycle.Vehicle;

public class MotorcycleSpot extends ParkingSpot {

    public MotorcycleSpot(int id) {
        super(id);
    }

    @Override
    public boolean canFitVehicle(Vehicle vehicle) {
        return vehicle instanceof Motorcycle;
    }

    @Override
    public boolean assignVehicle(Vehicle vehicle) {
        if (canFitVehicle(vehicle)) {
            return super.assignVehicle(vehicle);
        }
        return false;
    }
}
