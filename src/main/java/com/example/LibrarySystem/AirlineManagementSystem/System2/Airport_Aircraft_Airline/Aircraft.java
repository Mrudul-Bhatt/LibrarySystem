package com.example.LibrarySystem.AirlineManagementSystem.System2.Airport_Aircraft_Airline;

import com.example.LibrarySystem.AirlineManagementSystem.System2.Seat_FlightSeat.Seat;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Aircraft {
    private String name;
    private String code;
    private String model;
    private int seatCapacity;
    private List<Seat> seats;

    public Aircraft(String name, String code, String model, int seatCapacity, List<Seat> seats) {
        this.name = name;
        this.code = code;
        this.model = model;
        this.seatCapacity = seatCapacity;
        this.seats = seats;
    }

    // Get available seats
    public List<Seat> getAvailableSeats() {
        List<Seat> availableSeats = new ArrayList<>();
        for (Seat seat : seats) {
            if (seat.isAvailable()) {
                availableSeats.add(seat);
            }
        }
        return availableSeats;
    }

    // Book a seat
    public boolean bookSeat(String seatNumber) {
        for (Seat seat : seats) {
            if (seat.getSeatNumber().equals(seatNumber) && seat.isAvailable()) {
                seat.book();
                return true;
            }
        }
        return false;
    }

    // Cancel a seat booking
    public boolean cancelSeatBooking(String seatNumber) {
        for (Seat seat : seats) {
            if (seat.getSeatNumber().equals(seatNumber) && !seat.isAvailable()) {
                seat.cancelBooking();
                return true;
            }
        }
        return false;
    }

    // Get total seats count
    public int getTotalSeats() {
        return seats.size();
    }

    // Check seat availability
    public boolean isSeatAvailable(String seatNumber) {
        for (Seat seat : seats) {
            if (seat.getSeatNumber().equals(seatNumber)) {
                return seat.isAvailable();
            }
        }
        return false;
    }
}
