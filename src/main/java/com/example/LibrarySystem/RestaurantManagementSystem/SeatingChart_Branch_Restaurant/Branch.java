package com.example.LibrarySystem.RestaurantManagementSystem.SeatingChart_Branch_Restaurant;

import com.example.LibrarySystem.RestaurantManagementSystem.Address_Account_Person_Customer_Employee.Address;
import com.example.LibrarySystem.RestaurantManagementSystem.Menu_MenuSection_MenuItem.Menu;
import com.example.LibrarySystem.RestaurantManagementSystem.Order_Kitchen_Reservation.Kitchen;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Branch {
    private String name;
    private Address location;
    private Kitchen kitchen;
    private Menu menu;

//    public Address addSeatingChart();
}
