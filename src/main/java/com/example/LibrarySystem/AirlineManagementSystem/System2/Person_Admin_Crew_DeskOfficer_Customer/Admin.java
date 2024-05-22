package com.example.LibrarySystem.AirlineManagementSystem.System2.Person_Admin_Crew_DeskOfficer_Customer;

import com.example.LibrarySystem.AirlineManagementSystem.System2.Airport_Aircraft_Airline.Aircraft;
import com.example.LibrarySystem.AirlineManagementSystem.System2.Flight_FlightInstance.Flight;

public class Admin extends Person {
    public boolean addAircraft(Aircraft aircraft);

    public boolean addFlight(Flight flight);

    public boolean cancelFlight(Flight flight);

    public boolean assignCrew(Flight flight);

    public boolean blockUser(User user);

    public boolean unblockUser(User user);
}
