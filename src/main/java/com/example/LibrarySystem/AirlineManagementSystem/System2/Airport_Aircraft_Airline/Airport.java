package com.example.LibrarySystem.AirlineManagementSystem.System2.Airport_Aircraft_Airline;

import com.example.LibrarySystem.AirlineManagementSystem.System2.Address_Acc_Passenger.Address;
import com.example.LibrarySystem.AirlineManagementSystem.System2.Flight_FlightInstance.Flight;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Airport {
    private String name;
    private String code;
    private Address address;
    private List<Flight> flights;

    public Airport(String name, String code, Address address) {
        this.name = name;
        this.code = code;
        this.address = address;
        this.flights = new ArrayList<>();
    }

    // Add a flight
    public boolean addFlight(Flight flight) {
        return flights.add(flight);
    }

    // Remove a flight
    public boolean removeFlight(Flight flight) {
        return flights.remove(flight);
    }

    // Get flights by departure or arrival airport
    public List<Flight> getFlightsByAirport(Airport airport) {
        List<Flight> airportFlights = new ArrayList<>();
        for (Flight flight : flights) {
            if (flight.getDeparture().equals(airport) || flight.getArrival().equals(airport)) {
                airportFlights.add(flight);
            }
        }
        return airportFlights;
    }

    // Get all flights
    public List<Flight> getAllFlights() {
        return new ArrayList<>(flights);
    }
}
