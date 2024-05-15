// package com.example.LibrarySystem.RestaurantManagementSystem.Address_Account_Person_Customer_Employee;
package com.example.LibrarySystem.RestaurantManagementSystem.Address_Account_Person_Customer_Employee;

import com.example.LibrarySystem.RestaurantManagementSystem.Order_Kitchen_Reservation.Order;

import java.util.List;

public class Chef extends Employee {
    private List<Order> orders;

    public Chef(String name, String email, String phone) {
        super(name, email, phone);
    }

    public boolean prepareOrder(Order order) {
        return orders.add(order);
    }

}
