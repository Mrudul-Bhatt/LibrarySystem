package com.example.LibrarySystem.B_ElevatorSystem.System3.ElevatorSystem_Building;

import com.example.LibrarySystem.B_ElevatorSystem.System3.Door_Floor_ElevatorCar.ElevatorCar;
import com.example.LibrarySystem.B_ElevatorSystem.System3.Door_Floor_ElevatorCar.Floor;
import com.example.LibrarySystem.B_ElevatorSystem.System3.Enums.Direction;
import com.example.LibrarySystem.B_ElevatorSystem.System3.Enums.ElevatorState;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Building {
    private static Building building = null;
    private List<Floor> floors;
    private List<ElevatorCar> elevators;

    private Building() {
        this.floors = new ArrayList<>();
        this.elevators = new ArrayList<>();
    }

    public static Building getInstance() {
        if (building == null) {
            building = new Building();
        }
        return building;
    }

    public List<Floor> getFloors() {
        return floors;
    }

    public List<ElevatorCar> getElevators() {
        return elevators;
    }

    public int getTopFloorNumber() {
        return floors.size() - 1;
    }

    public void requestElevator(int floorNumber, Direction direction) {
        // Logic to handle elevator requests from a specific floor in a specific direction
        System.out.println("Elevator requested at floor: " + floorNumber + " going " + direction);
        // Find the nearest available elevator
        ElevatorCar nearestElevator = findNearestElevator(floorNumber, direction);
        if (nearestElevator != null) {
            nearestElevator.move(floorNumber);
        }
    }

    private ElevatorCar findNearestElevator(int floorNumber, Direction direction) {
        // Logic to find the nearest available elevator
        ElevatorCar nearestElevator = null;
        int minDistance = Integer.MAX_VALUE;

        for (ElevatorCar elevator : elevators) {
            int distance = Math.abs(elevator.getCurrentFloor() - floorNumber);
            if (distance < minDistance && elevator.getState() != ElevatorState.MOVING) {
                nearestElevator = elevator;
                minDistance = distance;
            }
        }

        return nearestElevator;
    }
}
