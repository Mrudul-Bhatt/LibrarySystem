package com.example.LibrarySystem.AirlineManagementSystem.System2.Airport_Aircraft_Airline;

import com.example.LibrarySystem.AirlineManagementSystem.System2.Flight_FlightInstance.Flight;
import com.example.LibrarySystem.AirlineManagementSystem.System2.Person_Admin_Crew_DeskOfficer_Customer.Crew;

import java.util.List;

public class Airline {
    // The Airline is a singleton class that ensures it will have only one active instance at a time
    private static Airline airline = null;
    private String name;
    private String code;
    private List<Flight> flights;
    private List<Aircraft> aircrafts;
    private List<Crew> crew;

    // Created a static method to access the singleton instance of Airline class
    public static Airline getInstance() {
        if (airline == null) {
            airline = new Airline();
        }
        return airline;
    }
}
