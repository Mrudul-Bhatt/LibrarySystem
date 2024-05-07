package com.example.LibrarySystem.HotelManagementSystem.System3.Room_RoomKey_RoomHousekeeping;

import com.example.LibrarySystem.HotelManagementSystem.System3.Enums.RoomStatus;
import com.example.LibrarySystem.HotelManagementSystem.System3.Enums.RoomStyle;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Room {
    private String roomNumber;
    private RoomStyle style;
    private RoomStatus status;
    private double bookingPrice;
    private boolean isSmoking;
    private List<RoomKey> keys;
    private List<RoomHousekeeping> housekeepingLog;

    public Room(String roomNumber, RoomStyle style, double bookingPrice, boolean isSmoking) {
        this.roomNumber = roomNumber;
        this.style = style;
        this.status = RoomStatus.AVAILABLE; // Assuming all rooms start as available
        this.bookingPrice = bookingPrice;
        this.isSmoking = isSmoking;
        this.keys = new ArrayList<>();
        this.housekeepingLog = new ArrayList<>();
    }

    public boolean isRoomAvailable() {
        return this.status == RoomStatus.AVAILABLE;
    }

    public boolean checkin() {
        if (this.status == RoomStatus.RESERVED) {
            this.status = RoomStatus.OCCUPIED;
            return true;
        }
        return false;
    }

    public boolean checkout() {
        if (this.status == RoomStatus.OCCUPIED) {
            this.status = RoomStatus.AVAILABLE;
            return true;
        }
        return false;
    }
}
