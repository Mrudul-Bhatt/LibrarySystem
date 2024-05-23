package com.example.LibrarySystem.AirlineManagementSystem.System2.Person_Admin_Crew_DeskOfficer_Customer;

import com.example.LibrarySystem.AirlineManagementSystem.System2.Address_Acc_Passenger.Account;
import com.example.LibrarySystem.AirlineManagementSystem.System2.Address_Acc_Passenger.Address;
import com.example.LibrarySystem.AirlineManagementSystem.System2.Flight_FlightInstance.FlightInstance;

import java.util.ArrayList;
import java.util.List;

public class Crew extends Person {
    private List<FlightInstance> schedule;

    public Crew(String name, Address address, String email, String phone, Account account) {
        super(name, address, email, phone, account);
        this.schedule = new ArrayList<>();
    }

    // View schedule
    public List<FlightInstance> viewSchedule() {
        return new ArrayList<>(schedule);
    }

    // Add flight instance to schedule
    public boolean addFlightInstanceToSchedule(FlightInstance flightInstance) {
        if (!schedule.contains(flightInstance)) {
            return schedule.add(flightInstance);
        }
        return false;
    }

    // Remove flight instance from schedule
    public boolean removeFlightInstanceFromSchedule(FlightInstance flightInstance) {
        return schedule.remove(flightInstance);
    }

    // Check if crew is available for a new flight instance
    public boolean isAvailableFor(FlightInstance flightInstance) {
        for (FlightInstance fi : schedule) {
            if (fi.getDepartureTime().equals(flightInstance.getDepartureTime())) {
                return false;
            }
        }
        return true;
    }

}
