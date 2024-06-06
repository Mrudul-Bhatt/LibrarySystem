package com.example.LibrarySystem.A_ParkingLotSystem.System3.Account_Admin_ParkingAttendant;

import com.example.LibrarySystem.A_ParkingLotSystem.System3.DisplayBoard_ParkingRate_ParkingLot.DisplayBoard;
import com.example.LibrarySystem.A_ParkingLotSystem.System3.DisplayBoard_ParkingRate_ParkingLot.ParkingLot;
import com.example.LibrarySystem.A_ParkingLotSystem.System3.Enums.AccountStatus;
import com.example.LibrarySystem.A_ParkingLotSystem.System3.ParkingSpot_Handicapped_Compact_Large_Motorcycle.ParkingSpot;
import com.example.LibrarySystem.A_ParkingLotSystem.System3.ParkingTicket_Entrance_Exit_Payment.Entrance;
import com.example.LibrarySystem.A_ParkingLotSystem.System3.ParkingTicket_Entrance_Exit_Payment.Exit;
import com.example.LibrarySystem.A_ParkingLotSystem.System3.Person_Address.Person;

import java.util.ArrayList;

public class Admin extends Account {
    // spot here refers to an instance of the ParkingSpot class
    public Admin(String userName, String password, Person person, AccountStatus status) {
        super(userName, password, person, status);
    }

    public boolean addParkingSpot(ParkingSpot spot) {
        ParkingLot parkingLot = ParkingLot.getInstance();
        DisplayBoard displayBoard = parkingLot.getDisplayBoard();

        String spotType = spot.getClass().getSimpleName();
        displayBoard.getParkingSpots().computeIfAbsent(spotType, k -> new ArrayList<>()).add(spot);

        return true;
    }

    public boolean addDisplayBoard(DisplayBoard displayBoard) {
        ParkingLot parkingLot = ParkingLot.getInstance();
        parkingLot.setDisplayBoard(displayBoard);
        return true;
    }

    public boolean addEntrance(Entrance entrance) {
        ParkingLot parkingLot = ParkingLot.getInstance();
        parkingLot.addEntrance(entrance);
        return true;
    }

    public boolean addExit(Exit exit) {
        ParkingLot parkingLot = ParkingLot.getInstance();
        parkingLot.addExit(exit);
        return true;
    }
}
