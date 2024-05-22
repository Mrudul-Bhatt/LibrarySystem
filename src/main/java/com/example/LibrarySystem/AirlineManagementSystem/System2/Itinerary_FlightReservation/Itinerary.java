package com.example.LibrarySystem.AirlineManagementSystem.System2.Itinerary_FlightReservation;

import com.example.LibrarySystem.AirlineManagementSystem.System2.Address_Acc_Passenger.Passenger;
import com.example.LibrarySystem.AirlineManagementSystem.System2.Airport_Aircraft_Airline.Airport;

import java.util.Date;
import java.util.List;

public class Itinerary {
    private Airport startingAirport;
    private Airport finalAirport;
    private Date creationDate;
    private List<FlightReservation> reservations;
    private List<Passenger> passengers;

    public boolean makeReservation();

    public boolean makePayment();
}
