package com.example.LibrarySystem.B_ElevatorSystem.System3.ElevatorPanel_HallPanel_Display;

import com.example.LibrarySystem.B_ElevatorSystem.System3.Button_Door_Hall_Elevator.DoorButton;
import com.example.LibrarySystem.B_ElevatorSystem.System3.Button_Door_Hall_Elevator.ElevatorButton;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ElevatorPanel {
    private List<ElevatorButton> floorButtons;
    private DoorButton openButton;
    private DoorButton closeButton;

    public ElevatorPanel(List<ElevatorButton> floorButtons, DoorButton openButton, DoorButton closeButton) {
        this.floorButtons = floorButtons;
        this.openButton = openButton;
        this.closeButton = closeButton;
    }

    public void pressFloorButton(int floorNumber) {
        for (ElevatorButton button : floorButtons) {
            if (button.getDestinationFloorNumber() == floorNumber) {
                button.pressDown();
                System.out.println("Pressed floor button for floor: " + floorNumber);
                // Add logic to notify the elevator system
                break;
            }
        }
    }

    public void releaseFloorButton(int floorNumber) {
        for (ElevatorButton button : floorButtons) {
            if (button.getDestinationFloorNumber() == floorNumber) {
                button.release();
                System.out.println("Released floor button for floor: " + floorNumber);
                break;
            }
        }
    }

    public void pressOpenButton() {
        openButton.pressDown();
        System.out.println("Pressed open door button");
        // Add logic to open the elevator door
    }

    public void releaseOpenButton() {
        openButton.release();
        System.out.println("Released open door button");
    }

    public void pressCloseButton() {
        closeButton.pressDown();
        System.out.println("Pressed close door button");
        // Add logic to close the elevator door
    }

    public void releaseCloseButton() {
        closeButton.release();
        System.out.println("Released close door button");
    }
}
