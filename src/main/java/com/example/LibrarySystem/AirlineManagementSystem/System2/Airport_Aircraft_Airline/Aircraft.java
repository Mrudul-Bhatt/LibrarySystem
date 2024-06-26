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

    // Get seat configuration
    public List<Seat> getSeats() {
        return new ArrayList<>(seats);
    }

    // Get total seats count
    public int getTotalSeats() {
        return seats.size();
    }

    // Get a seat by seat number
    public Seat getSeatByNumber(String seatNumber) {
        for (Seat seat : seats) {
            if (seat.getSeatNumber().equals(seatNumber)) {
                return seat;
            }
        }
        return null;
    }
}
