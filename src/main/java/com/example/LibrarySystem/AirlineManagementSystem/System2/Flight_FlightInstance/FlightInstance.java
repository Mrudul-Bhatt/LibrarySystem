package com.example.LibrarySystem.AirlineManagementSystem.System2.Flight_FlightInstance;

import com.example.LibrarySystem.AirlineManagementSystem.System2.Airport_Aircraft_Airline.Aircraft;
import com.example.LibrarySystem.AirlineManagementSystem.System2.DesignPatterns.Observer.Observer;
import com.example.LibrarySystem.AirlineManagementSystem.System2.DesignPatterns.Observer.Subject;
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
public class FlightInstance implements Subject {
    private Flight flight;
    private Date departureTime;
    private String gate;
    private FlightStatus status;
    private Aircraft aircraft;
    private List<FlightSeat> seats;
    private List<Crew> assignedCrew;
    private List<Observer> observers;  // List of observers

    public FlightInstance(Flight flight, Date departureTime, String gate, Aircraft aircraft) {
        this.flight = flight;
        this.departureTime = departureTime;
        this.gate = gate;
        this.status = FlightStatus.SCHEDULED;
        this.aircraft = aircraft;
        this.seats = new ArrayList<>();
        this.observers = new ArrayList<>();  // Initialize the observers list
        initializeSeats(aircraft);
    }

    // Subject interface methods
    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(String message) {
        for (Observer observer : observers) {
            observer.update(message);
        }
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

    // Check if a specific seat is available
    public boolean isSeatAvailable(String seatNumber) {
        for (FlightSeat seat : seats) {
            if (seat.getSeat().getSeatNumber().equals(seatNumber)) {
                return seat.isAvailable();
            }
        }
        return false;
    }

    // Get a specific seat by its number
    public FlightSeat getSeatByNumber(String seatNumber) {
        for (FlightSeat seat : seats) {
            if (seat.getSeat().getSeatNumber().equals(seatNumber)) {
                return seat;
            }
        }
        return null;
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
