package com.example.LibrarySystem.B_ElevatorSystem.System3;

import com.example.LibrarySystem.B_ElevatorSystem.System3.Button_Door_Hall_Elevator.DoorButton;
import com.example.LibrarySystem.B_ElevatorSystem.System3.Door_Floor_ElevatorCar.ElevatorCar;
import com.example.LibrarySystem.B_ElevatorSystem.System3.Door_Floor_ElevatorCar.Floor;
import com.example.LibrarySystem.B_ElevatorSystem.System3.ElevatorPanel_HallPanel_Display.Display;
import com.example.LibrarySystem.B_ElevatorSystem.System3.ElevatorPanel_HallPanel_Display.ElevatorPanel;
import com.example.LibrarySystem.B_ElevatorSystem.System3.ElevatorSystem_Building.Building;
import com.example.LibrarySystem.B_ElevatorSystem.System3.ElevatorSystem_Building.ElevatorSystem;
import com.example.LibrarySystem.B_ElevatorSystem.System3.Enums.Direction;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Create floors
        List<Floor> floors = new ArrayList<>();
        for (int i = 0; i < 10; i++) { // Assuming a 10-floor building
            floors.add(new Floor(i, new ArrayList<>(), new ArrayList<>()));
        }

        // Create elevators
        List<ElevatorCar> elevators = new ArrayList<>();
        for (int i = 0; i < 3; i++) { // Assuming 3 elevators
            Display display = new Display();
            ElevatorPanel panel = new ElevatorPanel(new ArrayList<>(), new DoorButton(), new DoorButton());
            elevators.add(new ElevatorCar(i, display, panel));
        }

        // Create the building instance
        Building building = Building.getInstance();
        building.setFloors(floors);
        building.setElevators(elevators);

        // Create the elevator system instance
        ElevatorSystem elevatorSystem = ElevatorSystem.getInstance(building);

        // Simulate some elevator requests
        elevatorSystem.requestElevator(3, Direction.UP);
        elevatorSystem.requestElevator(7, Direction.DOWN);

        // Simulate the elevator system monitoring and dispatching
        elevatorSystem.monitoring();
        elevatorSystem.dispatcher();

        // Additional requests to see more interactions
        elevatorSystem.requestElevator(5, Direction.UP);
        elevatorSystem.requestElevator(1, Direction.DOWN);

        // Monitor the system state after additional requests
        elevatorSystem.monitoring();
    }
}
