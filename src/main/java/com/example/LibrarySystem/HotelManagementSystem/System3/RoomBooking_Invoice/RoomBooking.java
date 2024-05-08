package com.example.LibrarySystem.HotelManagementSystem.System3.RoomBooking_Invoice;

import com.example.LibrarySystem.HotelManagementSystem.System3.Enums.BookingStatus;
import com.example.LibrarySystem.HotelManagementSystem.System3.Notification.Notification;
import com.example.LibrarySystem.HotelManagementSystem.System3.Room_RoomKey_RoomHousekeeping.Room;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
public class RoomBooking {
    private String reservationNumber;
    private Date startDate;
    private int durationInDays;
    private BookingStatus status;
    private Date checkin;
    private Date checkout;
    private String guestId;
    private Room room;
    private Invoice invoice;
    private List<Notification> notifications;
    private List<Invoice> serviceInvoices;

    public RoomBooking(Date starDate, int durationInDays, String guestId, Room room) {
        this.reservationNumber = Double.toString(Math.random());
        this.startDate = starDate;
        this.durationInDays = durationInDays;
        this.status = BookingStatus.PENDING;
        this.guestId = guestId;
        this.room = room;
        this.notifications = new ArrayList<>();
        this.serviceInvoices = new ArrayList<>();
    }

    public boolean addInvoiceServices(Invoice invoice) {
        this.serviceInvoices.add(invoice);
        return true;
    }

    public boolean makePaymentForServices() {
        System.out.println("Payment done");
        return true;
    }
}
