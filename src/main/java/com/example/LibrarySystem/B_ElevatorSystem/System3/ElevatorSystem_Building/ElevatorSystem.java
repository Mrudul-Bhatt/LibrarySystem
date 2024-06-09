package com.example.LibrarySystem.B_ElevatorSystem.System3.ElevatorSystem_Building;

import com.example.LibrarySystem.B_ElevatorSystem.System3.Door_Floor_ElevatorCar.ElevatorCar;
import com.example.LibrarySystem.B_ElevatorSystem.System3.Enums.Direction;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ElevatorSystem {
    private static ElevatorSystem system = null;
    private Building building;

    private ElevatorSystem(Building building) {
        this.building = building;
    }

    public static ElevatorSystem getInstance(Building building) {
        if (system == null) {
            system = new ElevatorSystem(building);
        }
        return system;
    }

    public void monitoring() {
        // Logic to monitor the state of all elevators and floors
        System.out.println("Monitoring the elevator system...");
        for (ElevatorCar elevator : building.getElevators()) {
            System.out.println(
                    "Elevator " + elevator.getId() + " is at floor " + elevator.getCurrentFloor() + " in state " +
                            elevator.getState());
        }
    }

    public void dispatcher() {
        // Logic to dispatch elevators based on requests
        System.out.println("Dispatching elevators...");
        // For simplicity, we could implement a basic dispatcher that checks for requests and assigns elevators
    }

    public void requestElevator(int floorNumber, Direction direction) {
        System.out.println("Processing request for elevator at floor " + floorNumber + " going " + direction);
        building.requestElevator(floorNumber, direction);
    }
}
