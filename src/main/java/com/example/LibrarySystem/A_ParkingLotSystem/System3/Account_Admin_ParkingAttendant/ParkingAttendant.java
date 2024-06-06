package com.example.LibrarySystem.A_ParkingLotSystem.System3.Account_Admin_ParkingAttendant;

import com.example.LibrarySystem.A_ParkingLotSystem.System3.DisplayBoard_ParkingRate_ParkingLot.ParkingLot;
import com.example.LibrarySystem.A_ParkingLotSystem.System3.Enums.AccountStatus;
import com.example.LibrarySystem.A_ParkingLotSystem.System3.ParkingTicket_Entrance_Exit_Payment.Exit;
import com.example.LibrarySystem.A_ParkingLotSystem.System3.ParkingTicket_Entrance_Exit_Payment.ParkingTicket;
import com.example.LibrarySystem.A_ParkingLotSystem.System3.Person_Address.Person;

public class ParkingAttendant extends Account {
    public ParkingAttendant(String userName, String password, Person person, AccountStatus status) {
        super(userName, password, person, status);
    }

    public boolean processTicket(String ticketNumber) {
        ParkingLot parkingLot = ParkingLot.getInstance();
        ParkingTicket ticket = parkingLot.getTickets().get(Integer.parseInt(ticketNumber));

        if (ticket == null) {
            System.out.println("Invalid ticket number.");
            return false;
        }

        Exit exit = new Exit(1); // For simplicity, we use a default exit
        exit.validateTicket(ticket);
        return true;
    }

}
