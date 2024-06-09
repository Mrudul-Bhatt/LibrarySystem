package com.example.LibrarySystem.B_ElevatorSystem.System3.Door_Floor_ElevatorCar;

import com.example.LibrarySystem.B_ElevatorSystem.System3.Enums.DoorState;

public class Door {
    private DoorState state;

    public Door() {
        this.state = DoorState.CLOSE; // Initial state
    }

    public boolean isOpen() {
        return state == DoorState.OPEN;
    }

    public void open() {
        if (state != DoorState.OPEN) {
            state = DoorState.OPEN;
            System.out.println("Door is now open.");
        }
    }

    public void close() {
        if (state != DoorState.CLOSE) {
            state = DoorState.CLOSE;
            System.out.println("Door is now closed.");
        }
    }
}
