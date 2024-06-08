package com.example.LibrarySystem.B_ElevatorSystem.System3.Door_Floor_ElevatorCar;

import com.example.LibrarySystem.B_ElevatorSystem.System3.ElevatorPanel_HallPanel_Display.Display;
import com.example.LibrarySystem.B_ElevatorSystem.System3.ElevatorPanel_HallPanel_Display.ElevatorPanel;
import com.example.LibrarySystem.B_ElevatorSystem.System3.Enums.ElevatorState;

public class ElevatorCar {
    private int id;
    private Door door;
    private ElevatorState state;
    private Display display;
    private ElevatorPanel panel;

    public void move();

    public void stop();

    public void openDoor();

    public void closeDoor();
}
