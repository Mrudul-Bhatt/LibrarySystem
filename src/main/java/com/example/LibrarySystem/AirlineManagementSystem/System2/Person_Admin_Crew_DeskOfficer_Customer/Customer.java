package com.example.LibrarySystem.AirlineManagementSystem.System2.Person_Admin_Crew_DeskOfficer_Customer;

import com.example.LibrarySystem.AirlineManagementSystem.System2.Itinerary_FlightReservation.Itinerary;

import java.util.List;

public class Customer extends Person {
    private int customerId;

    public List<Itinerary> viewItinerary();

    public boolean createItinerary();

    public boolean createReservation();

    public boolean assignSeat();

    public boolean makePayment();
}
