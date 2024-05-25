package com.example.LibrarySystem.AirlineManagementSystem.System2.Person_Admin_Crew_DeskOfficer_Customer;

import com.example.LibrarySystem.AirlineManagementSystem.System2.Address_Acc_Passenger.Account;
import com.example.LibrarySystem.AirlineManagementSystem.System2.Address_Acc_Passenger.Address;
import com.example.LibrarySystem.AirlineManagementSystem.System2.Address_Acc_Passenger.Passenger;
import com.example.LibrarySystem.AirlineManagementSystem.System2.Airport_Aircraft_Airline.Airport;
import com.example.LibrarySystem.AirlineManagementSystem.System2.Flight_FlightInstance.FlightInstance;
import com.example.LibrarySystem.AirlineManagementSystem.System2.Itinerary_FlightReservation.FlightReservation;
import com.example.LibrarySystem.AirlineManagementSystem.System2.Itinerary_FlightReservation.Itinerary;
import com.example.LibrarySystem.AirlineManagementSystem.System2.Payment.Payment;

import java.util.List;

public class FrontDeskOfficer extends Person {
    public FrontDeskOfficer(String name, Address address, String email, String phone, Account account) {
        super(name, address, email, phone, account);
    }

    // View a customer's itineraries
    public List<Itinerary> viewItinerary(Customer customer) {
        return customer.viewItinerary();
    }

    // Create a new itinerary for a customer
    public Itinerary createItinerary(Customer customer, Airport startingAirport, Airport finalAirport) {
        return customer.createItinerary(startingAirport, finalAirport);
    }

    // Create a reservation for a customer
    public FlightReservation createReservation(Customer customer, Itinerary itinerary, FlightInstance flightInstance,
            List<Passenger> passengers) {
        return customer.createReservation(itinerary, flightInstance, passengers);
    }

    // Assign a seat to a passenger for a customer's reservation
    public boolean assignSeat(Customer customer, FlightReservation reservation, Passenger passenger,
            String seatNumber) {
        return customer.assignSeat(reservation, passenger, seatNumber);
    }

    // Make a payment for a customer's itinerary
    public boolean makePayment(Customer customer, Itinerary itinerary, Payment paymentMethod) {
        return customer.makePayment(itinerary, paymentMethod);
    }

}
