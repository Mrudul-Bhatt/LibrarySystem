package com.example.LibrarySystem.AirlineManagementSystem.System2.Itinerary_FlightReservation;

import com.example.LibrarySystem.AirlineManagementSystem.System2.Address_Acc_Passenger.Passenger;
import com.example.LibrarySystem.AirlineManagementSystem.System2.Airport_Aircraft_Airline.Airport;
import com.example.LibrarySystem.AirlineManagementSystem.System2.Payment.Payment;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
public class Itinerary {
    private Airport startingAirport;
    private Airport finalAirport;
    private Date creationDate;
    private List<FlightReservation> reservations;
    private List<Passenger> passengers;

    public Itinerary(Airport startingAirport, Airport finalAirport, Date creationDate) {
        this.startingAirport = startingAirport;
        this.finalAirport = finalAirport;
        this.creationDate = creationDate;
        this.reservations = new ArrayList<>();
        this.passengers = new ArrayList<>();
    }

    // Make a reservation and add it to the itinerary
    public boolean makeReservation(FlightReservation reservation) {
        return reservations.add(reservation);
    }

    // Cancel a reservation in the itinerary
    public boolean cancelReservation(FlightReservation reservation) {
        if (reservations.remove(reservation)) {
            reservation.cancelReservation();
            return true;
        }
        return false;
    }

    // Add a passenger to the itinerary
    public boolean addPassenger(Passenger passenger) {
        if (!passengers.contains(passenger)) {
            passengers.add(passenger);
            return true;
        }
        return false;
    }

    // Remove a passenger from the itinerary
    public boolean removePassenger(Passenger passenger) {
        return passengers.remove(passenger);
    }

    // Make a payment for the itinerary
    public boolean makePayment(Payment payment) {
        if (payment.makePayment()) {
            for (FlightReservation reservation : reservations) {
                reservation.confirmReservation();
            }
            return true;
        }
        return false;
    }

    // View all reservations in the itinerary
    public List<FlightReservation> viewReservations() {
        return new ArrayList<>(reservations);
    }
}
