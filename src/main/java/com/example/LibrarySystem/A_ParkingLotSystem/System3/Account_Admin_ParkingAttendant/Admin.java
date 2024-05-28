package com.example.LibrarySystem.A_ParkingLotSystem.System3.Account_Admin_ParkingAttendant;

import com.example.LibrarySystem.A_ParkingLotSystem.System3.DisplayBoard_ParkingRate_ParkingLot.DisplayBoard;
import com.example.LibrarySystem.A_ParkingLotSystem.System3.ParkingSpot_Handicapped_Compact_Large_Motorcycle.ParkingSpot;
import com.example.LibrarySystem.A_ParkingLotSystem.System3.ParkingTicket_Entrance_Exit_Payment.Entrance;
import com.example.LibrarySystem.A_ParkingLotSystem.System3.ParkingTicket_Entrance_Exit_Payment.Exit;

public class Admin extends Account {
    // spot here refers to an instance of the ParkingSpot class
    public boolean addParkingSpot(ParkingSpot spot);

    // displayBoard here refers to an instance of the DisplayBoard class
    public boolean addDisplayBoard(DisplayBoard displayBoard);

    // entrance here refers to an instance of the Entrance class
    public boolean addEntrance(Entrance entrance);

    // exit here refers to an instance of the Exit class
    public boolean addExit(Exit exit);
}
