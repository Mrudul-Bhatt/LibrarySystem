package com.example.LibrarySystem.AirlineManagementSystem.System2.Flight_FlightInstance;

import com.example.LibrarySystem.AirlineManagementSystem.System2.Airport_Aircraft_Airline.Airport;

import java.util.List;

public class Flight {
    private String flightNo;
    private int durationMin;
    private Airport departure;
    private Airport arrival;
    private List<FlightInstance> instances;
}
