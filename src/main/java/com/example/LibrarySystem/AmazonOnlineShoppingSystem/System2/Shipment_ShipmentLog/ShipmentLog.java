package com.example.LibrarySystem.AmazonOnlineShoppingSystem.System2.Shipment_ShipmentLog;

import com.example.LibrarySystem.AmazonOnlineShoppingSystem.System2.Enums.ShipmentStatus;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class ShipmentLog {
    private String shipmentNumber;
    private Date creationDate;
    private ShipmentStatus status;
}
