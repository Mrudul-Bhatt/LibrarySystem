package com.example.LibrarySystem.A_ParkingLotSystem.System3.DisplayBoard_ParkingRate_ParkingLot;

public class ParkingRate {
//    private double hours;
//    private double rate;
//    public void calculate();

    private double hourlyRate;

    public ParkingRate() {
        this.hourlyRate = 10.0; // Default rate
    }

    public ParkingRate(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    public double calculate(long durationMillis) {
        double hours = (double) durationMillis / (1000 * 60 * 60);
        return hours * hourlyRate;
    }

    public double getRate() {
        return hourlyRate;
    }

    public void setRate(double rate) {
        this.hourlyRate = rate;
    }

}
