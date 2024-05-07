package com.example.LibrarySystem.HotelManagementSystem.System3.Person_PersonTypes;

import com.example.LibrarySystem.HotelManagementSystem.System3.Room_RoomKey_RoomHousekeeping.Room;

public class Housekeeper extends Person {
    private List<Room> assignedRooms;

    public Housekeeper(String name, Address address, String email, String phone, Account account) {
        super(name, address, email, phone, account);
        this.assignedRooms = new ArrayList<>();
    }

    public boolean assignToRoom(Room room) {
        if (!assignedRooms.contains(room)) {
            assignedRooms.add(room);
            return true;
        }
        return false; // Room is already assigned to this housekeeper
    }

    public boolean removeFromRoom(Room room) {
        return assignedRooms.remove(room); // Remove room from assigned rooms
    }
}
