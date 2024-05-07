package com.example.LibrarySystem.HotelManagementSystem.System3.Person_PersonTypes;

import com.example.LibrarySystem.HotelManagementSystem.System3.Enums.BookingStatus;
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

    public boolean bookRoom(Room room, Date startDate, int durationInDays) {
        if (room.isRoomAvailable()) { // Check if the room is available for booking
            // Create a new RoomBooking
            RoomBooking booking = new RoomBooking(generateReservationNumber(), startDate, durationInDays,
                    BookingStatus.PENDING, null, null, this.getId(), room, null, new ArrayList<>());
            // Add the booking to the guest's list of bookings
            bookings.add(booking);
            // Update totalRoomsCheckedIn
            totalRoomsCheckedIn++;
            // Update the room status to booked
            room.checkin();
            return true;
        } else {
            return false; // Room is not available for booking
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

    private String generateReservationNumber() {
        // Logic to generate a unique reservation number
        return ""; // Placeholder for now
    }
}
