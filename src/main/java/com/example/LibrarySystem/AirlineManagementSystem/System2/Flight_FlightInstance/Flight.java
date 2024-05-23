package com.example.LibrarySystem.AirlineManagementSystem.System2.Flight_FlightInstance;

import com.example.LibrarySystem.AirlineManagementSystem.System2.Airport_Aircraft_Airline.Airport;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Getter
@Setter
public class Flight {
    private String flightNo;
    private int durationMin;
    private Airport departure;
    private Airport arrival;
    private List<FlightInstance> instances;

    public Flight(String flightNo, int durationMin, Airport departure, Airport arrival) {
        this.flightNo = flightNo;
        this.durationMin = durationMin;
        this.departure = departure;
        this.arrival = arrival;
        this.instances = new ArrayList<>();
    }

    // Add a flight instance to the flight
    public void addFlightInstance(FlightInstance instance) {
        instances.add(instance);
    }

    // Find all flight instances on a specific date
    public List<FlightInstance> findInstancesByDate(Date date) {
        List<FlightInstance> result = new ArrayList<>();
        for (FlightInstance instance : instances) {
            if (isSameDay(instance.getDepartureTime(), date)) {
                result.add(instance);
            }
        }
        return result;
    }

    // Check if two dates are on the same day
    private boolean isSameDay(Date date1, Date date2) {
        Calendar cal1 = Calendar.getInstance();
        Calendar cal2 = Calendar.getInstance();
        cal1.setTime(date1);
        cal2.setTime(date2);
        return cal1.get(Calendar.YEAR) == cal2.get(Calendar.YEAR) &&
                cal1.get(Calendar.DAY_OF_YEAR) == cal2.get(Calendar.DAY_OF_YEAR);
    }

    // Find the next available flight instance
    public FlightInstance getNextAvailableInstance() {
        Date now = new Date();
        FlightInstance nextInstance = null;
        for (FlightInstance instance : instances) {
            if (instance.getDepartureTime().after(now)) {
                if (nextInstance == null || instance.getDepartureTime().before(nextInstance.getDepartureTime())) {
                    nextInstance = instance;
                }
            }
        }
        return nextInstance;
    }

    // Cancel all instances of the flight
    public void cancelAllInstances() {
        for (FlightInstance instance : instances) {
            instance.cancel();
        }
    }
}
