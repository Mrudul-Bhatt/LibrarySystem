package com.example.LibrarySystem.AmazonOnlineShoppingSystem.System2.Shipment_ShipmentLog;

import java.util.Date;

public class Shipment {
    private String shipmentNumber;
    private Date shipmentDate;
    private Date estimatedArrival;
    private String shipmentMethod;
    private List<ShipmentLog> shipmentLogs;

    public boolean addShipmentLog(ShipmentLog shipmentLog);
}
