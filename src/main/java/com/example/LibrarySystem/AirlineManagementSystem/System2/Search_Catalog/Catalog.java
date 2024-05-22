package com.example.LibrarySystem.AirlineManagementSystem.System2.Search_Catalog;

import com.example.LibrarySystem.AirlineManagementSystem.System2.Airport_Aircraft_Airline.Airport;
import com.example.LibrarySystem.AirlineManagementSystem.System2.Flight_FlightInstance.FlightInstance;

import java.util.Date;
import java.util.List;

public class Catalog implements Search {
    private HashMap<Quartet<Airport, Airport, Date, Date>, List<FlightInstance>> flights;

    public List<FlightInstance> searchFlight(Airport source, Airport dest, Date arrival, Date departure) {
        // functionality
    }
}
