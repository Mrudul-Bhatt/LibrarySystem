package com.example.LibrarySystem.AirlineManagementSystem.System2.Seat_FlightSeat;

import com.example.LibrarySystem.AirlineManagementSystem.System2.Enums.SeatStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FlightSeat {
    private Seat seat;
    private double fare;
    private SeatStatus status;
    private String reservationNumber;

    public FlightSeat(Seat seat, double fare) {
        this.seat = seat;
        this.fare = fare;
        this.status = SeatStatus.AVAILABLE;
    }

    // Book the seat
    public boolean bookSeat(String reservationNumber) {
        if (this.status == SeatStatus.AVAILABLE) {
            this.status = SeatStatus.BOOKED;
            this.reservationNumber = reservationNumber;
            return true;
        }
        return false;
    }

    // Cancel the booking
    public boolean cancelBooking() {
        if (this.status == SeatStatus.BOOKED) {
            this.status = SeatStatus.AVAILABLE;
            this.reservationNumber = null;
            return true;
        }
        return false;
    }

    // Check if the seat is available
    public boolean isAvailable() {
        return this.status == SeatStatus.AVAILABLE;
    }

    // Check if the seat is booked
    public boolean isBooked() {
        return this.status == SeatStatus.BOOKED;
    }
}
