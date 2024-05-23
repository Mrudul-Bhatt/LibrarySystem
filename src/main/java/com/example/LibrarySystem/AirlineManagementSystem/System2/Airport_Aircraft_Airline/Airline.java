package com.example.LibrarySystem.AirlineManagementSystem.System2.Airport_Aircraft_Airline;

import com.example.LibrarySystem.AirlineManagementSystem.System2.Flight_FlightInstance.Flight;
import com.example.LibrarySystem.AirlineManagementSystem.System2.Person_Admin_Crew_DeskOfficer_Customer.Crew;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Airline {
    private static Airline airline = null;
    private String name;
    private String code;
    private List<Flight> flights;
    private List<Aircraft> aircrafts;
    private List<Crew> crew;

    private Airline(String name, String code) {
        this.name = name;
        this.code = code;
        this.flights = new ArrayList<>();
        this.aircrafts = new ArrayList<>();
        this.crew = new ArrayList<>();
    }

    // Singleton instance access method
    public static Airline getInstance(String name, String code) {
        if (airline == null) {
            airline = new Airline(name, code);
        }
        return airline;
    }

    // Add a flight
    public boolean addFlight(Flight flight) {
        return flights.add(flight);
    }

    // Remove a flight
    public boolean removeFlight(Flight flight) {
        return flights.remove(flight);
    }

    // Add an aircraft
    public boolean addAircraft(Aircraft aircraft) {
        return aircrafts.add(aircraft);
    }

    // Remove an aircraft
    public boolean removeAircraft(Aircraft aircraft) {
        return aircrafts.remove(aircraft);
    }

    // Assign crew to a flight
    public boolean assignCrew(Flight flight, Crew crewMember) {
        if (flights.contains(flight)) {
            flight.addCrewMember(crewMember);
            return true;
        }
        return false;
    }

    // Get flight by flight number
    public Flight getFlightByNumber(String flightNo) {
        for (Flight flight : flights) {
            if (flight.getFlightNo().equals(flightNo)) {
                return flight;
            }
        }
        return null;
    }

    // Get all flights
    public List<Flight> getAllFlights() {
        return new ArrayList<>(flights);
    }

}
