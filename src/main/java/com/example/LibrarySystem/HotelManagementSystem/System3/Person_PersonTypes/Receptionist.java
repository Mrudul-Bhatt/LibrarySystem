package com.example.LibrarySystem.HotelManagementSystem.System3.Person_PersonTypes;

import java.util.List;

import com.example.LibrarySystem.HotelManagementSystem.System3.Address_Account.Account;
import com.example.LibrarySystem.HotelManagementSystem.System3.Address_Account.Address;
import com.example.LibrarySystem.HotelManagementSystem.System3.RoomBooking_Invoice.RoomBooking;

public class Receptionist extends Person {
    public Receptionist(String name, Address address, String email, String phone, Account account) {
        super(name, address, email, phone, account);
    }

    public List<Person> searchMember(String name) {
        // Logic to search for members by name
        // This method could involve querying a database or an external API
        return null; // Placeholder return statement
    }

    public boolean createBooking(RoomBooking booking) {
        // Logic to create a booking
        // This method could involve checking room availability, creating a new booking,
        // etc.
        return false; // Placeholder return statement
    }
}
