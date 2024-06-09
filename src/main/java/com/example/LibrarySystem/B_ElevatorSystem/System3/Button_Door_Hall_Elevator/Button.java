package com.example.LibrarySystem.B_ElevatorSystem.System3.Button_Door_Hall_Elevator;

public abstract class Button {
    private boolean status;

    public void pressDown() {
        status = true;
    }

    public void release() {
        status = false;
    }

    public boolean isPressed() {
        return status;
    }
}
