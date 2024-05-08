package com.example.LibrarySystem.HotelManagementSystem.System3.Service_ServiceTypes;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Amenity extends Service {
    private String name;
    private String description;

    public Amenity(Date issuedAt, String name, String description) {
        super(issuedAt);
        this.name = name;
        this.description = description;
    }
}
