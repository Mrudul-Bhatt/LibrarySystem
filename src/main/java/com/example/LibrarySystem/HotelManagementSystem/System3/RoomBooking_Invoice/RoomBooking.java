package com.example.LibrarySystem.HotelManagementSystem.System3.RoomBooking_Invoice;

import com.example.LibrarySystem.HotelManagementSystem.System3.Enums.BookingStatus;
import com.example.LibrarySystem.HotelManagementSystem.System3.Notification.Notification;
import com.example.LibrarySystem.HotelManagementSystem.System3.Room_RoomKey_RoomHousekeeping.Room;

import java.util.Date;
import java.util.List;

public class RoomBooking {
    private String reservationNumber;
    private Date startDate;
    private int durationInDays;
    private BookingStatus status;
    private Date checkin;
    private Date checkout;
    private int guestId;
    private Room room;
    private Invoice invoice;
    private List<Notification> notifications;

    public static RoomBooking fetchDetails(String reservationNumber) {
        // Logic to fetch room booking details from the database based on reservation
        // number
        // This method could involve querying the database or an external API
        return null; // Placeholder return statement
    }

    public boolean cancelBooking() {
        if (status == BookingStatus.PENDING || status == BookingStatus.CONFIRMED) {
            // Cancel the booking
            status = BookingStatus.CANCELLED;
            // Remove the booking from the room's bookings list
            room.getBookings().remove(this);
            // Remove reference to the room from the booking
            room = null;
            return true;
        }
        return false; // Booking cannot be cancelled in other statuses like checked-in or checked-out
    }
}
