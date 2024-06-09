package com.example.LibrarySystem.B_ElevatorSystem.System3.Button_Door_Hall_Elevator;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ElevatorButton extends Button {
    private int destinationFloorNumber;

    public ElevatorButton(int destinationFloorNumber) {
        this.destinationFloorNumber = destinationFloorNumber;
    }

    @Override
    public void pressDown() {
        super.pressDown();
        // Logic to handle pressing the elevator button, e.g., notifying the system
        // that a request to go to the destination floor has been made
    }

    @Override
    public void release() {
        super.release();
        // Logic to handle releasing the elevator button, if any
    }

}
