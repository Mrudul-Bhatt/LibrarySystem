package com.example.LibrarySystem.B_ElevatorSystem.System3.Door_Floor_ElevatorCar;

import com.example.LibrarySystem.B_ElevatorSystem.System3.ElevatorPanel_HallPanel_Display.Display;
import com.example.LibrarySystem.B_ElevatorSystem.System3.ElevatorPanel_HallPanel_Display.HallPanel;
import com.example.LibrarySystem.B_ElevatorSystem.System3.ElevatorSystem_Building.Building;
import com.example.LibrarySystem.B_ElevatorSystem.System3.Enums.Direction;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Floor {
    private List<Display> displays;
    private List<HallPanel> panels;
    private int floorNumber;

    public Floor(int floorNumber, List<Display> displays, List<HallPanel> panels) {
        this.floorNumber = floorNumber;
        this.displays = displays;
        this.panels = panels;
    }

    public boolean isBottomMost() {
        return floorNumber == 0;
    }

    public boolean isTopMost() {
        // Assuming the topmost floor number is known or can be retrieved
        return floorNumber == Building.getInstance().getTopFloorNumber();
    }

    public void updateDisplays(int floor, Direction direction) {
        for (Display display : displays) {
            display.updateFloor(floor);
            display.updateDirection(direction);
            display.showHallDisplay();
        }
    }

    public void updatePanels() {
        // Logic to update the state of the panels if needed
    }
}
