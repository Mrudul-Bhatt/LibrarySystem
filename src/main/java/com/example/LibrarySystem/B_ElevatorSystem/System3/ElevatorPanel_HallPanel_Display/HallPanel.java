package com.example.LibrarySystem.B_ElevatorSystem.System3.ElevatorPanel_HallPanel_Display;

import com.example.LibrarySystem.B_ElevatorSystem.System3.Button_Door_Hall_Elevator.HallButton;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HallPanel {
    private HallButton up;
    private HallButton down;

    public HallPanel(HallButton up, HallButton down) {
        this.up = up;
        this.down = down;
    }

    public void pressUpButton() {
        up.pressDown();
        System.out.println("Pressed up hall button");
        // Add logic to notify the system for an up request
    }

    public void releaseUpButton() {
        up.release();
        System.out.println("Released up hall button");
    }

    public void pressDownButton() {
        down.pressDown();
        System.out.println("Pressed down hall button");
        // Add logic to notify the system for a down request
    }

    public void releaseDownButton() {
        down.release();
        System.out.println("Released down hall button");
    }

}
