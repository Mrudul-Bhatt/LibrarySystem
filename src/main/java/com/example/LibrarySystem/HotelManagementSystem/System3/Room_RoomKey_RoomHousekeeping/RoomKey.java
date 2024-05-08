package com.example.LibrarySystem.HotelManagementSystem.System3.Room_RoomKey_RoomHousekeeping;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RoomKey {
    private String keyId;
    private String barcode;
    private Date issuedAt;
    private boolean isActive;
    private boolean isMaster;

    public RoomKey(String keyId, String barcode, Date issuedAt, boolean isMaster) {
        this.keyId = keyId;
        this.barcode = barcode;
        this.issuedAt = issuedAt;
        this.isActive = true; // Assume the key is initially active
        this.isMaster = isMaster;
    }

    public boolean assignRoom(Room room) {
        if (isActive) { // Check if the key is active
            // Add this key to the room's keys list
            room.getKeys().add(this);
            // Update the key's status to inactive after assigning it to the room
            isActive = false;
            return true;
        }
        return false; // Key is not active and cannot be assigned to a room
    }
}
