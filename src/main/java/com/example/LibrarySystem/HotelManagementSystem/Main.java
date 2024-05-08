package com.example.LibrarySystem.HotelManagementSystem;

import java.util.Date;

import com.example.LibrarySystem.HotelManagementSystem.System3.Address_Account.Account;
import com.example.LibrarySystem.HotelManagementSystem.System3.Address_Account.Address;
import com.example.LibrarySystem.HotelManagementSystem.System3.Enums.AccountStatus;
import com.example.LibrarySystem.HotelManagementSystem.System3.Enums.RoomStyle;
import com.example.LibrarySystem.HotelManagementSystem.System3.Hotel_HotelBranch.Hotel;
import com.example.LibrarySystem.HotelManagementSystem.System3.Hotel_HotelBranch.HotelBranch;
import com.example.LibrarySystem.HotelManagementSystem.System3.Person_PersonTypes.Guest;
import com.example.LibrarySystem.HotelManagementSystem.System3.RoomBooking_Invoice.Invoice;
import com.example.LibrarySystem.HotelManagementSystem.System3.RoomBooking_Invoice.RoomBooking;
import com.example.LibrarySystem.HotelManagementSystem.System3.Room_RoomKey_RoomHousekeeping.Room;
import com.example.LibrarySystem.HotelManagementSystem.System3.Service_ServiceTypes.Amenity;
import com.example.LibrarySystem.HotelManagementSystem.System3.Service_ServiceTypes.KitchenService;
import com.example.LibrarySystem.HotelManagementSystem.System3.Service_ServiceTypes.RoomService;

public class Main {
    public static void main(String[] args) {
        // Create a hotel instance (singleton)
        Hotel hotel = Hotel.getInstance();

        // Create a hotel branch
        HotelBranch branch = new HotelBranch("Branch 1", new Address("123 Main St", "City", "State", "12345", "India"));
        hotel.addBranchLocation(branch);

        // Create rooms for the branch
        Room room1 = new Room("101", RoomStyle.STANDARD, 100.0, false);
        Room room2 = new Room("102", RoomStyle.FAMILY_SUITE, 150.0, true);
        branch.addRoom(room1);
        branch.addRoom(room2);

        // Create a guest
        Guest guest = new Guest("John Doe",
                new Address("456 Elm St", "City", "State", "54321", "India"),
                "john@example.com",
                "123456789",
                new Account("828121", "Password", AccountStatus.ACTIVE));

        // Book a room for the guest
        // RoomBooking booking = new RoomBooking(new Date(), 3, BookingStatus.PENDING,
        // null, null, guest.getId(),
        // room1, null, null);
        RoomBooking roomBooking = guest.bookRoom(RoomStyle.STANDARD, "Branch 1", new Date(), 3);

        guest.checkIn(roomBooking);
        // Create an amenity service
        Amenity amenity = new Amenity(new Date(), "WiFi", "High-speed internet access");

        // Add an invoice item for the amenity service
        amenity.addInvoiceAndServiceItem(new Invoice(10.0), roomBooking);

        // Create a room service
        RoomService roomService = new RoomService(new Date(), new Date(), true);

        // Add an invoice item for the room service
        roomService.addInvoiceAndServiceItem(new Invoice(20.0), roomBooking);

        // Create a kitchen service
        KitchenService kitchenService = new KitchenService(new Date(), new Date());

        // Add an invoice item for the kitchen service
        kitchenService.addInvoiceAndServiceItem(new Invoice(15.0), roomBooking);

        // Clear invoice dues for added services
        guest.checkOut(roomBooking);
    }
}
