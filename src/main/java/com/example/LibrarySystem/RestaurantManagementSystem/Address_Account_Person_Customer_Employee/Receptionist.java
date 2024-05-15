package com.example.LibrarySystem.RestaurantManagementSystem.Address_Account_Person_Customer_Employee;

import com.example.LibrarySystem.RestaurantManagementSystem.Order_Kitchen_Reservation.Reservation;
import com.example.LibrarySystem.RestaurantManagementSystem.SeatingChart_Branch_Restaurant.Branch;

public class Receptionist extends Employee {
    Receptionist(String name, String email, String phone) {
        super(name, email, phone);
    }

    public boolean createReservation(Reservation reservation, Branch branch) {
        return branch.addReservation(reservation);
    }

}
