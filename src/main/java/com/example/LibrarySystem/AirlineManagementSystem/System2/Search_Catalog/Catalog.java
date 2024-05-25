package com.example.LibrarySystem.AirlineManagementSystem.System2.Search_Catalog;

import com.example.LibrarySystem.AirlineManagementSystem.System2.Airport_Aircraft_Airline.Airport;
import com.example.LibrarySystem.AirlineManagementSystem.System2.Flight_FlightInstance.Flight;
import com.example.LibrarySystem.AirlineManagementSystem.System2.Flight_FlightInstance.FlightInstance;

import java.util.*;

public class Catalog implements Search {
    private final HashMap<String, Flight> flightsByNumber;
    private final HashMap<Quartet<Airport, Airport, Date, Date>, List<FlightInstance>> flights;

    public Catalog() {
        this.flightsByNumber = new HashMap<>();
        this.flights = new HashMap<>();
    }

    // Add a flight to the catalog
    public void addFlight(Flight flight) {
        flightsByNumber.put(flight.getFlightNo(), flight);
    }

    // Remove a flight from the catalog
    public void removeFlight(String flightNo) {
        Flight flight = flightsByNumber.remove(flightNo);
        if (flight != null) {
            for (FlightInstance instance : flight.getInstances()) {
                Quartet<Airport, Airport, Date, Date> key = createKey(instance.getFlight().getDeparture(),
                        instance.getFlight().getArrival(),
                        instance.getDepartureTime(), instance.getDepartureTime());
                flights.get(key).remove(instance);
            }
        }
    }

    // Update flight information
    public void updateFlight(Flight flight) {
        removeFlight(flight.getFlightNo());
        addFlight(flight);
    }

    // Search for flight instances between airports on specific dates
    @Override
    public List<FlightInstance> searchFlight(Airport source, Airport destination, Date arrival, Date departure) {
        Quartet<Airport, Airport, Date, Date> key = createKey(source, destination, arrival, departure);
        return flights.getOrDefault(key, Collections.emptyList());
    }

    // Search for all flight instances of a specific flight number
    public List<FlightInstance> searchFlightByNumber(String flightNo) {
        Flight flight = flightsByNumber.get(flightNo);
        return flight != null ? flight.getInstances() : Collections.emptyList();
    }

    // Add a flight instance to the catalog
    public void addFlightInstance(FlightInstance instance) {
        Quartet<Airport, Airport, Date, Date> key = createKey(instance.getFlight().getDeparture(),
                instance.getFlight().getArrival(),
                instance.getDepartureTime(), instance.getDepartureTime());
        flights.computeIfAbsent(key, k -> new ArrayList<>()).add(instance);
    }

    // Remove a flight instance from the catalog
    public void removeFlightInstance(FlightInstance instance) {
        Quartet<Airport, Airport, Date, Date> key = createKey(instance.getFlight().getDeparture(),
                instance.getFlight().getArrival(),
                instance.getDepartureTime(), instance.getDepartureTime());
        List<FlightInstance> instances = flights.get(key);
        if (instances != null) {
            instances.remove(instance);
            if (instances.isEmpty()) {
                flights.remove(key);
            }
        }
    }

    // Helper method to create a key for the flight instances map
    private Quartet<Airport, Airport, Date, Date> createKey(Airport source, Airport destination, Date arrival,
            Date departure) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(arrival);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        Date arrivalDate = cal.getTime();

        cal.setTime(departure);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        Date departureDate = cal.getTime();

        return new Quartet<>(source, destination, arrivalDate, departureDate);
    }
}
