package com.example.LibrarySystem.HotelManagementSystem.System3.Service_ServiceTypes;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RoomService extends Service {
    private boolean isChargeable;
    private Date requestTime;

    public RoomService(Date issuedAt, Date requestTime, boolean isChargeable) {
        super(issuedAt);
        this.requestTime = requestTime;
        this.isChargeable = isChargeable;
    }
}
