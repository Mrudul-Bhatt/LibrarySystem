package com.example.LibrarySystem.B_ElevatorSystem.System3.ElevatorSystem_Building;

import java.util.List;

import com.example.LibrarySystem.B_ElevatorSystem.System3.Door_Floor_ElevatorCar.ElevatorCar;
import com.example.LibrarySystem.B_ElevatorSystem.System3.Door_Floor_ElevatorCar.Floor;

public class Building {
    private List<Floor> floor;
    private List<ElevatorCar> elevator;

    private static Building building = null;

    public static Building getInstance() {
        if (building == null) {
            building = new Building();
        }
        return building;
    }
}
