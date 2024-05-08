package com.example.LibrarySystem.HotelManagementSystem.System3.Hotel_HotelBranch;

import java.util.ArrayList;
import java.util.List;

import com.example.LibrarySystem.HotelManagementSystem.System3.Address_Account.Address;
import com.example.LibrarySystem.HotelManagementSystem.System3.Room_RoomKey_RoomHousekeeping.Room;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HotelBranch {
    private String name;
    private Address location;
    private List<Room> rooms;

    public HotelBranch(String name, Address location) {
        this.name = name;
        this.location = location;
        this.rooms = new ArrayList<>();
    }

    public boolean addRoom(Room room) {
        // Logic to add a room to the hotel branch
        // This method could involve checking if the room already exists, adding the
        // room to the list, etc.
        if (!rooms.contains(room)) {
            rooms.add(room);
            return true;
        }
        return false;
    }
}
