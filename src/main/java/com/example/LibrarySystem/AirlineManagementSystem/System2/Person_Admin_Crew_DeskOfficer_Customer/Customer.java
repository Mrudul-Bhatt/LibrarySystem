package com.example.LibrarySystem.AirlineManagementSystem.System2.Person_Admin_Crew_DeskOfficer_Customer;

import com.example.LibrarySystem.AirlineManagementSystem.System2.Address_Acc_Passenger.Account;
import com.example.LibrarySystem.AirlineManagementSystem.System2.Address_Acc_Passenger.Address;
import com.example.LibrarySystem.AirlineManagementSystem.System2.Address_Acc_Passenger.Passenger;
import com.example.LibrarySystem.AirlineManagementSystem.System2.Airport_Aircraft_Airline.Airport;
import com.example.LibrarySystem.AirlineManagementSystem.System2.Flight_FlightInstance.FlightInstance;
import com.example.LibrarySystem.AirlineManagementSystem.System2.Itinerary_FlightReservation.FlightReservation;
import com.example.LibrarySystem.AirlineManagementSystem.System2.Itinerary_FlightReservation.Itinerary;
import com.example.LibrarySystem.AirlineManagementSystem.System2.Payment.Payment;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class Customer extends Person {
    private int customerId;
    private List<Itinerary> itineraries;

    public Customer(String name, Address address, String email, String phone, Account account, int customerId) {
        super(name, address, email, phone, account);
        this.customerId = customerId;
        this.itineraries = new ArrayList<>();
    }

    // View all itineraries
    public List<Itinerary> viewItinerary() {
        return new ArrayList<>(itineraries);
    }

    // Create a new itinerary
    public Itinerary createItinerary(Airport startingAirport, Airport finalAirport) {
        Itinerary newItinerary = new Itinerary(startingAirport, finalAirport, new Date());
        itineraries.add(newItinerary);
        return newItinerary;
    }

    // Create a reservation
    public FlightReservation createReservation(Itinerary itinerary, FlightInstance flightInstance,
            List<Passenger> passengers) {
        FlightReservation reservation = new FlightReservation(UUID.randomUUID().toString(), flightInstance, new Date());
        itinerary.makeReservation(reservation);
        itinerary.setPassengers(passengers);
        return reservation;
    }

    // Assign a seat to a passenger
    public boolean assignSeat(FlightReservation reservation, Passenger passenger, String seatNumber) {
        return reservation.assignSeat(passenger, seatNumber);
    }

    // Make a payment for an itinerary
    public boolean makePayment(Itinerary itinerary, Payment paymentMethod) {
        return itinerary.makePayment(paymentMethod);
    }

}
