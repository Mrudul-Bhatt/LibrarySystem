package com.example.LibrarySystem.AirlineManagementSystem.System2.Itinerary_FlightReservation;

import com.example.LibrarySystem.AirlineManagementSystem.System2.Address_Acc_Passenger.Passenger;
import com.example.LibrarySystem.AirlineManagementSystem.System2.Enums.ReservationStatus;
import com.example.LibrarySystem.AirlineManagementSystem.System2.Flight_FlightInstance.FlightInstance;
import com.example.LibrarySystem.AirlineManagementSystem.System2.Seat_FlightSeat.FlightSeat;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class FlightReservation {
    private String reservationNumber;
    private FlightInstance flight;
    private HashMap<Passenger, FlightSeat> seatMap;
    private ReservationStatus status;
    private Date creationDate;

    public static FlightReservation fetchReservationDetails(String reservationNumber);

    public List<Passenger> getPassengers();
}
