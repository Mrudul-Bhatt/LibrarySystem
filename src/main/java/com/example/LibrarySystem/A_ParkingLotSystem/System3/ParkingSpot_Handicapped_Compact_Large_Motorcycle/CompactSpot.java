package com.example.LibrarySystem.A_ParkingLotSystem.System3.ParkingSpot_Handicapped_Compact_Large_Motorcycle;

import com.example.LibrarySystem.A_ParkingLotSystem.System3.Vehicle_Car_Van_Truck_Motorcycle.Car;
import com.example.LibrarySystem.A_ParkingLotSystem.System3.Vehicle_Car_Van_Truck_Motorcycle.Motorcycle;
import com.example.LibrarySystem.A_ParkingLotSystem.System3.Vehicle_Car_Van_Truck_Motorcycle.Vehicle;

public class CompactSpot extends ParkingSpot {

    public CompactSpot(int id) {
        super(id);
    }

    @Override
    public boolean canFitVehicle(Vehicle vehicle) {
        return vehicle instanceof Car || vehicle instanceof Motorcycle;
    }

    @Override
    public boolean assignVehicle(Vehicle vehicle) {
        if (canFitVehicle(vehicle)) {
            return super.assignVehicle(vehicle);
        }
        return false;
    }
}
