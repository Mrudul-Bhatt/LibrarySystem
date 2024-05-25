package com.example.LibrarySystem.AirlineManagementSystem.System2.Itinerary_FlightReservation;

import com.example.LibrarySystem.AirlineManagementSystem.System2.Address_Acc_Passenger.Passenger;
import com.example.LibrarySystem.AirlineManagementSystem.System2.Enums.ReservationStatus;
import com.example.LibrarySystem.AirlineManagementSystem.System2.Flight_FlightInstance.FlightInstance;
import com.example.LibrarySystem.AirlineManagementSystem.System2.Seat_FlightSeat.FlightSeat;
import lombok.Getter;
import lombok.Setter;

import java.util.*;

@Getter
@Setter
public class FlightReservation {
    private String reservationNumber;
    private FlightInstance flight;
    private HashMap<Passenger, FlightSeat> seatMap;
    private ReservationStatus status;
    private Date creationDate;

    public FlightReservation(String reservationNumber, FlightInstance flight, Date creationDate) {
        this.reservationNumber = reservationNumber;
        this.flight = flight;
        this.seatMap = new HashMap<>();
        this.status = ReservationStatus.PENDING;
        this.creationDate = creationDate;
    }

    // Fetch reservation details by reservation number
    public static FlightReservation fetchReservationDetails(String reservationNumber) {
        // Implementation to fetch details from the database or in-memory store
        return null; // placeholder
    }

    // Add a passenger to the reservation
    public boolean addPassenger(Passenger passenger, String seatNumber) {
        for (FlightSeat seat : flight.getSeats()) {
            if (seat.getSeat().getSeatNumber().equals(seatNumber) && seat.isAvailable()) {
                seatMap.put(passenger, seat);
                seat.bookSeat(reservationNumber);
                return true;
            }
        }
        return false;
    }

    public boolean assignSeat(Passenger passenger, String seatNumber) {
        if (!seatMap.containsKey(passenger)) {
            return false;
        }
        if (flight.isSeatAvailable(seatNumber)) {
            FlightSeat seat = flight.getSeatByNumber(seatNumber);
            if (seat != null) {
                seatMap.put(passenger, seat);
                seat.book();
                return true;
            }
        }
        return false;
    }

    // Remove a passenger from the reservation
    public boolean removePassenger(Passenger passenger) {
        FlightSeat seat = seatMap.remove(passenger);
        if (seat != null) {
            seat.cancelBooking();
            return true;
        }
        return false;
    }

    // Get the list of passengers
    public List<Passenger> getPassengers() {
        return new ArrayList<>(seatMap.keySet());
    }

    // Cancel the reservation
    public void cancelReservation() {
        this.status = ReservationStatus.CANCELED;
        for (Map.Entry<Passenger, FlightSeat> entry : seatMap.entrySet()) {
            entry.getValue().cancelBooking();
        }
    }

    // Confirm the reservation
    public void confirmReservation() {
        this.status = ReservationStatus.CONFIRMED;
    }
}
