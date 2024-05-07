package com.example.LibrarySystem.HotelManagementSystem.System3.Room_RoomKey_RoomHousekeeping;

import com.example.LibrarySystem.HotelManagementSystem.System3.Person_PersonTypes.Housekeeper;

import java.util.Date;

public class RoomHousekeeping {
    private String description;
    private Date startDatetime;
    private int duration;
    private Housekeeper housekeeper;

    public RoomHousekeeping(String description, Date startDatetime, int duration, Housekeeper housekeeper) {
        this.description = description;
        this.startDatetime = startDatetime;
        this.duration = duration;
        this.housekeeper = housekeeper;
    }

    public boolean addHousekeeping(Room room) {
        // Create a new housekeeping log entry
        RoomHousekeeping logEntry = new RoomHousekeeping(description, startDatetime, duration, housekeeper);

        // Add the housekeeping log entry to the room's housekeeping log
        room.getHousekeepingLog().add(logEntry);

        // Return true to indicate that the housekeeping log entry was successfully
        // added
        return true;
    }
}
