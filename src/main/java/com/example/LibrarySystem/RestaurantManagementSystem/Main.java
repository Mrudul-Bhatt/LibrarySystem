package com.example.LibrarySystem.RestaurantManagementSystem;

import com.example.LibrarySystem.RestaurantManagementSystem.Address_Account_Person_Customer_Employee.Address;
import com.example.LibrarySystem.RestaurantManagementSystem.Address_Account_Person_Customer_Employee.Waiter;
import com.example.LibrarySystem.RestaurantManagementSystem.Enums.TableStatus;
import com.example.LibrarySystem.RestaurantManagementSystem.Order_Kitchen_Reservation.Order;
import com.example.LibrarySystem.RestaurantManagementSystem.Order_Kitchen_Reservation.Reservation;
import com.example.LibrarySystem.RestaurantManagementSystem.SeatingChart_Branch_Restaurant.Branch;
import com.example.LibrarySystem.RestaurantManagementSystem.Table_TableSeat.Table;

public class Main {
    public static void main(String[] args) {
        // Create a branch
        Branch branch = new Branch("Main Branch", new Address("123 Main St", "City", "Country"));

        // Create a waiter
        Waiter waiter = new Waiter("John Doe", "john@example.com", "123456789");

        // Add the waiter to the branch staff
        branch.addEmployee(waiter);

        // Create a table
        Table table1 = new Table(1, TableStatus.Free, 4, 101);
        branch.addTable(table1);

        // Create a reservation
        Reservation reservation = new Reservation(/* Reservation details */);
        branch.addReservation(reservation);

        // Create an order
        Order order = new Order(/* Order details */);
        waiter.takeOrder(order);
    }
}
