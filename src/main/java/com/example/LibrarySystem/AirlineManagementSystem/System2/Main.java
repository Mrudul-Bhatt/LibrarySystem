package com.example.LibrarySystem.AirlineManagementSystem.System2;

import com.example.LibrarySystem.AirlineManagementSystem.System2.Address_Acc_Passenger.Address;
import com.example.LibrarySystem.AirlineManagementSystem.System2.Address_Acc_Passenger.Passenger;
import com.example.LibrarySystem.AirlineManagementSystem.System2.Airport_Aircraft_Airline.Aircraft;
import com.example.LibrarySystem.AirlineManagementSystem.System2.Airport_Aircraft_Airline.Airport;
import com.example.LibrarySystem.AirlineManagementSystem.System2.Enums.FlightStatus;
import com.example.LibrarySystem.AirlineManagementSystem.System2.Enums.SeatType;
import com.example.LibrarySystem.AirlineManagementSystem.System2.Flight_FlightInstance.Flight;
import com.example.LibrarySystem.AirlineManagementSystem.System2.Flight_FlightInstance.FlightInstance;
import com.example.LibrarySystem.AirlineManagementSystem.System2.Itinerary_FlightReservation.FlightReservation;
import com.example.LibrarySystem.AirlineManagementSystem.System2.Payment.CreditCard;
import com.example.LibrarySystem.AirlineManagementSystem.System2.Payment.Payment;
import com.example.LibrarySystem.AirlineManagementSystem.System2.Seat_FlightSeat.Seat;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        // Create addresses
        Address laxAddress = new Address(90001, "1 World Way", "Los Angeles", "CA", "USA");
        Address jfkAddress = new Address(10001, "JFK Airport", "New York", "NY", "USA");

        // Create airports
        Airport lax = new Airport("LAX", "LAX", laxAddress);
        Airport jfk = new Airport("JFK", "JFK", jfkAddress);

        // Create aircraft
        Aircraft aircraft = new Aircraft("Boeing 737", "B737", "737-800", 180);
        aircraft.addSeat(new Seat("1A", SeatType.REGULAR));
        aircraft.addSeat(new Seat("1B", SeatType.REGULAR));
        aircraft.addSeat(new Seat("1C", SeatType.REGULAR));

        // Create a flight
        Flight flight = new Flight("FL123", 180, lax, jfk);

        // Create a flight instance
        FlightInstance flightInstance =
                new FlightInstance(flight, new Date(), "Gate 5", FlightStatus.SCHEDULED, aircraft);

        // Create passengers
        Passenger passenger1 = new Passenger(1, "Alice", "F", new Date(), "P1234567");
        Passenger passenger2 = new Passenger(2, "Bob", "M", new Date(), "P7654321");

        // Register passengers as observers
        flightInstance.registerObserver(passenger1);
        flightInstance.registerObserver(passenger2);

        // Create a reservation
        FlightReservation reservation = new FlightReservation("R12345", flightInstance);
        reservation.addPassenger(passenger1, flightInstance.getSeatByNumber("1A"));
        reservation.addPassenger(passenger2, flightInstance.getSeatByNumber("1B"));

        // Change flight status and notify passengers
        System.out.println("Changing flight status to DELAYED...");
        flightInstance.setStatus(FlightStatus.DELAYED);

        // Make payment
        Payment payment = new CreditCard(1, 200.00, "Alice", "1234567812345678",
                "12/25", "123");
        if (payment.makePayment()) {
            System.out.println("Payment successful.");
        } else {
            System.out.println("Payment failed.");
        }

        // Cancel reservation
        System.out.println("Cancelling reservation...");
        reservation.cancelReservation();

        // Check seat availability
        System.out.println("Checking seat availability for seat 1A: " + flightInstance.isSeatAvailable("1A"));
    }
}
