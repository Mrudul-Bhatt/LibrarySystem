package com.example.LibrarySystem.HotelManagementSystem.System3.Person_PersonTypes;

import com.example.LibrarySystem.HotelManagementSystem.System3.Address_Account.Account;
import com.example.LibrarySystem.HotelManagementSystem.System3.Address_Account.Address;
import com.example.LibrarySystem.HotelManagementSystem.System3.BillTransaction.BillTransaction;
import com.example.LibrarySystem.HotelManagementSystem.System3.BillTransaction.CreditCardTransaction;
import com.example.LibrarySystem.HotelManagementSystem.System3.Enums.BookingStatus;
import com.example.LibrarySystem.HotelManagementSystem.System3.Enums.RoomStyle;
import com.example.LibrarySystem.HotelManagementSystem.System3.Hotel_HotelBranch.Hotel;
import com.example.LibrarySystem.HotelManagementSystem.System3.RoomBooking_Invoice.Invoice;
import com.example.LibrarySystem.HotelManagementSystem.System3.RoomBooking_Invoice.RoomBooking;
import com.example.LibrarySystem.HotelManagementSystem.System3.Room_RoomKey_RoomHousekeeping.Room;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
public class Guest extends Person {
    private int totalRoomsCheckedIn;
    private List<RoomBooking> bookings;

    public Guest(String name, Address address, String email, String phone, Account account) {
        super(name, address, email, phone, account);
        this.totalRoomsCheckedIn = 0;
        this.bookings = new ArrayList<>();
    }

    public RoomBooking bookRoom(RoomStyle roomStyle, String hotelBranchName, Date startDate, int durationInDays) {
        // Check if the room is available for booking
        Room room = Hotel.getInstance().findAvailableRoom(roomStyle, hotelBranchName);

        if (room != null) {
            // Create a new RoomBooking
            RoomBooking booking = new RoomBooking(startDate, durationInDays, this.getAccount().getId(), room);
            double totalAmount = booking.getRoom().getBookingPrice() * booking.getDurationInDays();
            Invoice invoice = new Invoice(totalAmount);
            booking.setInvoice(invoice);
            // Add the booking to the guest's list of bookings
            bookings.add(booking);
            // Update totalRoomsCheckedIn
            // totalRoomsCheckedIn++;
            // Update the room status to booked
            // room.checkin();
            return booking;
        } else {
            return null; // Room is not available for booking
        }
    }

    public boolean cancelBooking(RoomBooking booking) {
        if (booking.getStatus() == BookingStatus.PENDING || booking.getStatus() == BookingStatus.CONFIRMED) {
            // Remove the booking from the guest's list of bookings
            boolean removed = bookings.remove(booking);
            if (removed) {
                // Update totalRoomsCheckedIn
                totalRoomsCheckedIn--;
                // Update the room status to available
                booking.getRoom().checkout();
            }
            return removed;
        } else {
            return false; // Cannot cancel booking in other statuses like checked-in or checked-out
        }
    }

    public boolean checkIn(RoomBooking roomBooking) {
        if (roomBooking.getInvoice().isPaid() == true) {
            roomBooking.getRoom().checkin();
            this.totalRoomsCheckedIn++;
            return true;
        }
        return false;
    }

    public boolean checkOut(RoomBooking roomBooking) {
        if (roomBooking.getInvoice().isPaid() == true) {
            roomBooking.getRoom().checkout();
            // Clear payments for service invoices
            roomBooking.makePaymentForServices();
            this.totalRoomsCheckedIn--;
            return true;
        }
        return false;
    }

    public boolean makePayment(RoomBooking roomBooking, String cardNumber) {
        BillTransaction billTransaction = new CreditCardTransaction(roomBooking.getInvoice().getAmount(), cardNumber);
        billTransaction.setInvoice(roomBooking.getInvoice());
        Hotel.getInstance().makePayment(roomBooking, billTransaction);
        roomBooking.getInvoice().setPaid(true);
        return true;
    }

}
