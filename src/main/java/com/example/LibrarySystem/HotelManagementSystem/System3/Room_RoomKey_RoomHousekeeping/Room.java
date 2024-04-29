package com.example.LibrarySystem.HotelManagementSystem.System3.Room_RoomKey_RoomHousekeeping;

import com.example.LibrarySystem.HotelManagementSystem.System3.Enums.RoomStatus;
import com.example.LibrarySystem.HotelManagementSystem.System3.Enums.RoomStyle;

import java.util.List;

public class Room {
    private String roomNumber;
    private RoomStyle style;
    private RoomStatus status;
    private double bookingPrice;
    private boolean isSmoking;
    private List<RoomKey> keys;
    private List<RoomHousekeeping> housekeepingLog;

    public boolean isRoomAvailable() {
        return false;
    }

    public boolean checkin() {
        return false;
    }

    public boolean checkout() {
        return false;
    }
}
