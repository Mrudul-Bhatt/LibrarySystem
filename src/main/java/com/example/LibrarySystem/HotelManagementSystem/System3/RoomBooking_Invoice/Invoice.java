package com.example.LibrarySystem.HotelManagementSystem.System3.RoomBooking_Invoice;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Invoice {
    private double amount;
    private boolean isPaid;

    public Invoice(double amount) {
        this.amount = amount;
        this.isPaid = false; // Invoice is initially unpaid
    }

    public boolean createBill() {
        // Logic to create a bill for the invoice
        // This method could involve generating an invoice number, saving it to the
        // database, etc.
        return true; // Placeholder return statement
    }

    public boolean payInvoice() {
        if (!isPaid) {
            // Mark the invoice as paid
            isPaid = true;
            return true;
        }
        return false; // Invoice is already paid
    }
}
