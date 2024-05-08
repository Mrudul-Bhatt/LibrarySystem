package com.example.LibrarySystem.HotelManagementSystem.System3.Service_ServiceTypes;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class KitchenService extends Service {
    private Date requestTime;

    public KitchenService(Date issuedAt, Date requestTime) {
        super(issuedAt);
        this.requestTime = requestTime;
    }
}
