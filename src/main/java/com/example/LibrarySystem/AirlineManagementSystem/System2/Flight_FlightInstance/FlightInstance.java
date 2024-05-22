package com.example.LibrarySystem.AirlineManagementSystem.System2.Flight_FlightInstance;

import com.example.LibrarySystem.AirlineManagementSystem.System2.Airport_Aircraft_Airline.Aircraft;
import com.example.LibrarySystem.AirlineManagementSystem.System2.Enums.FlightStatus;
import com.example.LibrarySystem.AirlineManagementSystem.System2.Seat_FlightSeat.FlightSeat;

import java.util.Date;
import java.util.List;

public class FlightInstance {
    private Flight flight;
    private Date departureTime;
    private String gate;
    private FlightStatus status;
    private Aircraft aircraft;
    private List<FlightSeat> seats;
}
