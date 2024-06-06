package com.example.LibrarySystem.A_ParkingLotSystem.System3.ParkingSpot_Handicapped_Compact_Large_Motorcycle;

import com.example.LibrarySystem.A_ParkingLotSystem.System3.Vehicle_Car_Van_Truck_Motorcycle.Vehicle;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class ParkingSpot {
    private int id;
    private boolean isFree;
    private Vehicle vehicle;

    public ParkingSpot(int id) {
        this.id = id;
        this.isFree = true;
    }

    public boolean isFree() {
        return isFree;
    }

    public abstract boolean canFitVehicle(Vehicle vehicle);

    public boolean assignVehicle(Vehicle vehicle) {
        if (canFitVehicle(vehicle)) {
            this.vehicle = vehicle;
            this.isFree = false;
            return true;
        }
        return false;
    }

    public boolean removeVehicle() {
        this.vehicle = null;
        this.isFree = true;
        return true;
    }
}
