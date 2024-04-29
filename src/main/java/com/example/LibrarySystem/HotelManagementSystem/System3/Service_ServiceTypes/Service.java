package com.example.LibrarySystem.HotelManagementSystem.System3.Service_ServiceTypes;

import com.example.LibrarySystem.HotelManagementSystem.System3.RoomBooking_Invoice.Invoice;

import java.util.Date;

public abstract class Service {
    private Date issueAt;

    public boolean addInvoiceItem(Invoice invoice) {
        return false;
    }
}
