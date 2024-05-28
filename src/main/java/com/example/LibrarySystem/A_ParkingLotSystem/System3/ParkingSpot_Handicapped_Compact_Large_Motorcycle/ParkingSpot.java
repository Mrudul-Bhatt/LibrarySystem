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

    public boolean getIsFree();

    public abstract boolean assignVehicle(Vehicle vehicle);

    public boolean removeVehicle() {
        // definition
    }
}
