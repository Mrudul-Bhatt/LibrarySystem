package com.example.LibrarySystem.AirlineManagementSystem.System2.Flight_FlightInstance;

import com.example.LibrarySystem.AirlineManagementSystem.System2.Airport_Aircraft_Airline.Aircraft;
import com.example.LibrarySystem.AirlineManagementSystem.System2.Enums.FlightStatus;
import com.example.LibrarySystem.AirlineManagementSystem.System2.Enums.SeatType;
import com.example.LibrarySystem.AirlineManagementSystem.System2.Person_Admin_Crew_DeskOfficer_Customer.Crew;
import com.example.LibrarySystem.AirlineManagementSystem.System2.Seat_FlightSeat.FlightSeat;
import com.example.LibrarySystem.AirlineManagementSystem.System2.Seat_FlightSeat.Seat;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
public class FlightInstance {
    private Flight flight;
    private Date departureTime;
    private String gate;
    private FlightStatus status;
    private Aircraft aircraft;
    private List<FlightSeat> seats;
    private List<Crew> assignedCrew;

    public FlightInstance(Flight flight, Date departureTime, String gate, Aircraft aircraft) {
        this.flight = flight;
        this.departureTime = departureTime;
        this.gate = gate;
        this.status = FlightStatus.SCHEDULED;
        this.aircraft = aircraft;
        this.seats = new ArrayList<>();
        initializeSeats(aircraft);
    }

    // Initialize seats based on the aircraft
    private void initializeSeats(Aircraft aircraft) {
        for (Seat seat : aircraft.getSeats()) {
            seats.add(new FlightSeat(seat, calculateFare(seat.getType())));
        }
    }

    // Calculate fare based on seat type
    private double calculateFare(SeatType type) {
        return switch (type) {
            case REGULAR -> 100.0;
            case ACCESSIBLE -> 200.0;
            case EMERGENCY_EXIT -> 300.0;
            default -> 90.0;
        };
    }

    // Check seat availability
    public List<FlightSeat> getAvailableSeats() {
        List<FlightSeat> availableSeats = new ArrayList<>();
        for (FlightSeat seat : seats) {
            if (seat.isAvailable()) {
                availableSeats.add(seat);
            }
        }
        return availableSeats;
    }

    // Book a specific seat
    public boolean bookSeat(String seatNumber, String reservationNumber) {
        for (FlightSeat seat : seats) {
            if (seat.getSeat().getSeatNumber().equals(seatNumber) && seat.isAvailable()) {
                return seat.bookSeat(reservationNumber);
            }
        }
        return false;
    }

    // Cancel the flight instance
    public void cancel() {
        this.status = FlightStatus.CANCELED;
        for (FlightSeat seat : seats) {
            seat.cancelBooking();
        }
    }

    // Update the flight status
    public void updateStatus(FlightStatus newStatus) {
        this.status = newStatus;
    }

    // Add a crew member to the flight instance
    public boolean assignCrewMember(Crew crew) {
        if (!assignedCrew.contains(crew)) {
            return assignedCrew.add(crew);
        }
        return false;
    }

    // Remove a crew member from the flight instance
    public boolean removeCrewMember(Crew crew) {
        return assignedCrew.remove(crew);
    }
}
