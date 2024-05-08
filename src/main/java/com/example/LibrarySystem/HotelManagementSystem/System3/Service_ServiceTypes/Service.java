package com.example.LibrarySystem.HotelManagementSystem.System3.Service_ServiceTypes;

import com.example.LibrarySystem.HotelManagementSystem.System3.RoomBooking_Invoice.Invoice;
import com.example.LibrarySystem.HotelManagementSystem.System3.RoomBooking_Invoice.RoomBooking;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
public abstract class Service {
    private Date issueAt;

    public boolean addInvoiceAndServiceItem(Invoice invoice, RoomBooking roomBooking) {
        roomBooking.getRoom().addServices(this);
        roomBooking.addInvoiceServices(invoice);
        return true;
    }
}
