package com.example.LibrarySystem.RestaurantManagementSystem.Address_Account_Person_Customer_Employee;

import com.example.LibrarySystem.RestaurantManagementSystem.Order_Kitchen_Reservation.Order;

import java.util.List;

public class Waiter extends Employee {
    private List<Order> orders;

    public Waiter(String name, String email, String phone) {
        super(name, email, phone);
    }

    public boolean takeOrder(Order order) {
        return orders.add(order);
    }

}
