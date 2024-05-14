package com.example.LibrarySystem.RestaurantManagementSystem.Order_Kitchen_Reservation;

import com.example.LibrarySystem.RestaurantManagementSystem.Address_Account_Person_Customer_Employee.Customer;
import com.example.LibrarySystem.RestaurantManagementSystem.Enums.ReservationStatus;
import com.example.LibrarySystem.RestaurantManagementSystem.Notification.Notification;
import com.example.LibrarySystem.RestaurantManagementSystem.Table_TableSeat.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class Reservation {
    private int reservationID;
    private Date timeOfReservation;
    private int peopleCount;
    private ReservationStatus status;
    private String notes;
    private Date checkInTime;
    private Customer customer;
    private Table[] tables;
    private List<Notification> notifications;
}
