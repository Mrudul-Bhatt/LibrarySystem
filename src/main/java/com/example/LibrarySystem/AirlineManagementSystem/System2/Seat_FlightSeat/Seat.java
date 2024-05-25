package com.example.LibrarySystem.AirlineManagementSystem.System2.Seat_FlightSeat;

import com.example.LibrarySystem.AirlineManagementSystem.System2.Enums.SeatType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Seat {
    private String seatNumber;
    private SeatType type;

    public Seat(String seatNumber, SeatType type) {
        this.seatNumber = seatNumber;
        this.type = type;
    }

    // Check if the seat is of a certain type
    public boolean isType(SeatType type) {
        return this.type == type;
    }

    // Check if two seats are the same
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Seat seat = (Seat) o;
        return seatNumber.equals(seat.seatNumber) && type == seat.type;
    }
}
