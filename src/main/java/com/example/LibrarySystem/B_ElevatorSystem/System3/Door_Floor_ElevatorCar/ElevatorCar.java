package com.example.LibrarySystem.B_ElevatorSystem.System3.Door_Floor_ElevatorCar;

import com.example.LibrarySystem.B_ElevatorSystem.System3.ElevatorPanel_HallPanel_Display.Display;
import com.example.LibrarySystem.B_ElevatorSystem.System3.ElevatorPanel_HallPanel_Display.ElevatorPanel;
import com.example.LibrarySystem.B_ElevatorSystem.System3.Enums.ElevatorState;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ElevatorCar {
    private int id;
    private Door door;
    private ElevatorState state;
    private Display display;
    private ElevatorPanel panel;
    private int currentFloor;

    public ElevatorCar(int id, Display display, ElevatorPanel panel) {
        this.id = id;
        this.door = new Door();
        this.state = ElevatorState.STOPPED;
        this.display = display;
        this.panel = panel;
        this.currentFloor = 0; // Assume ground floor as initial position
    }

    public void move(int destinationFloor) {
        if (state != ElevatorState.STOPPED) {
            state = ElevatorState.MOVING;
            while (currentFloor != destinationFloor) {
                if (currentFloor < destinationFloor) {
                    currentFloor++;
                } else {
                    currentFloor--;
                }
                display.updateFloor(currentFloor);
                System.out.println("Elevator is now at floor: " + currentFloor);
            }
            state = ElevatorState.STOPPED;
            System.out.println("Elevator has reached the destination floor: " + destinationFloor);
        }
    }

    public void stop() {
        if (state == ElevatorState.MOVING) {
            state = ElevatorState.STOPPED;
            System.out.println("Elevator is stopped at floor: " + currentFloor);
        }
    }

    public void openDoor() {
        if (state == ElevatorState.STOPPED) {
            door.open();
        } else {
            System.out.println("Cannot open door while elevator is moving.");
        }
    }

    public void closeDoor() {
        door.close();
    }

    public void setCurrentFloor(int currentFloor) {
        this.currentFloor = currentFloor;
        display.updateFloor(currentFloor);
    }
}
