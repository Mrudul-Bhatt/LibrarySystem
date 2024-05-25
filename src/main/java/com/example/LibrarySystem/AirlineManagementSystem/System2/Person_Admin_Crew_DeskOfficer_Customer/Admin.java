package com.example.LibrarySystem.AirlineManagementSystem.System2.Person_Admin_Crew_DeskOfficer_Customer;

import com.example.LibrarySystem.AirlineManagementSystem.System2.Address_Acc_Passenger.Account;
import com.example.LibrarySystem.AirlineManagementSystem.System2.Address_Acc_Passenger.Address;
import com.example.LibrarySystem.AirlineManagementSystem.System2.Airport_Aircraft_Airline.Aircraft;
import com.example.LibrarySystem.AirlineManagementSystem.System2.Airport_Aircraft_Airline.Airline;
import com.example.LibrarySystem.AirlineManagementSystem.System2.Enums.AccountStatus;
import com.example.LibrarySystem.AirlineManagementSystem.System2.Enums.FlightStatus;
import com.example.LibrarySystem.AirlineManagementSystem.System2.Flight_FlightInstance.Flight;
import com.example.LibrarySystem.AirlineManagementSystem.System2.Flight_FlightInstance.FlightInstance;

public class Admin extends Person {
    public Admin(String name, Address address, String email, String phone, Account account) {
        super(name, address, email, phone, account);
    }

    // Add an aircraft
    public boolean addAircraft(Aircraft aircraft) {
        Airline airline = Airline.getInstance();
        return airline.addAircraft(aircraft);
    }

    // Remove an aircraft
    public boolean removeAircraft(Aircraft aircraft) {
        Airline airline = Airline.getInstance();
        return airline.removeAircraft(aircraft);
    }

    // Add a flight
    public boolean addFlight(Flight flight) {
        Airline airline = Airline.getInstance();
        return airline.addFlight(flight);
    }

    // Remove a flight
    public boolean removeFlight(Flight flight) {
        Airline airline = Airline.getInstance();
        return airline.removeFlight(flight);
    }

    // Cancel a flight
    public boolean cancelFlight(FlightInstance flight) {
        flight.setStatus(FlightStatus.CANCELED);
        return true;
    }

    // Assign crew to a flight
    public boolean assignCrew(Flight flight, Crew crewMember) {
        Airline airline = Airline.getInstance();
        return airline.assignCrew(flight, crewMember);
    }

    // Block a user
    public boolean blockUser(Person user) {
        user.getAccount().setStatus(AccountStatus.BLOCKED);
        return true;
    }

    // Unblock a user
    public boolean unblockUser(Person user) {
        user.getAccount().setStatus(AccountStatus.ACTIVE);
        return true;
    }

}
