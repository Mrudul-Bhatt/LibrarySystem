package com.example.LibrarySystem.B_ElevatorSystem.System3.Button_Door_Hall_Elevator;

import com.example.LibrarySystem.B_ElevatorSystem.System3.Enums.Direction;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HallButton extends Button {
    private Direction buttonSign;

    public HallButton(Direction buttonSign) {
        this.buttonSign = buttonSign;
    }

    @Override
    public void pressDown() {
        super.pressDown();
        // Logic to handle pressing the hall button, e.g., notifying the system
        // that an elevator is requested in the specified direction
    }

    @Override
    public void release() {
        super.release();
        // Logic to handle releasing the hall button, if any
    }

}
