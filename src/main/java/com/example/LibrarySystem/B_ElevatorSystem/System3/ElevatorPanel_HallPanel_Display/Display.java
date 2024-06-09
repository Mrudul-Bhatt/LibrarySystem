package com.example.LibrarySystem.B_ElevatorSystem.System3.ElevatorPanel_HallPanel_Display;

import com.example.LibrarySystem.B_ElevatorSystem.System3.Enums.Direction;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Display {
    private int floor;
    private int capacity;
    private Direction direction;

    public void showElevatorDisplay() {
        System.out.println("Elevator is currently at floor: " + floor + " going " + direction);
    }

    public void showHallDisplay() {
        System.out.println("Hall display shows elevator at floor: " + floor + " with direction: " + direction);
    }

    public void updateFloor(int floor) {
        this.floor = floor;
    }

    public void updateDirection(Direction direction) {
        this.direction = direction;
    }

    public void updateCapacity(int capacity) {
        this.capacity = capacity;
    }
}
