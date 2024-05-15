package com.example.LibrarySystem.RestaurantManagementSystem.SeatingChart_Branch_Restaurant;

import com.example.LibrarySystem.RestaurantManagementSystem.Address_Account_Person_Customer_Employee.Address;
import com.example.LibrarySystem.RestaurantManagementSystem.Address_Account_Person_Customer_Employee.Employee;
import com.example.LibrarySystem.RestaurantManagementSystem.Menu_MenuSection_MenuItem.Menu;
import com.example.LibrarySystem.RestaurantManagementSystem.Order_Kitchen_Reservation.Kitchen;
import com.example.LibrarySystem.RestaurantManagementSystem.Order_Kitchen_Reservation.Reservation;
import com.example.LibrarySystem.RestaurantManagementSystem.Table_TableSeat.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class Branch {
    private String name;
    private Address location;
    private Kitchen kitchen;
    private Menu menu;
    private List<Reservation> reservations;
    private List<Table> tables;
    private List<Employee> employees;

    public Branch(String name, Address location) {
        this.name = name;
        this.location = location;
        this.reservations = new ArrayList<>();
        this.tables = new ArrayList<>();
    }

    public boolean addReservation(Reservation reservation) {
        return reservations.add(reservation);
    }

    public boolean removeReservation(Reservation reservation) {
        return reservations.remove(reservation);
    }

    public boolean addTable(Table table) {
        return tables.add(table);
    }

    public boolean removeTable(Table table) {
        return tables.remove(table);
    }

    public boolean addEmployee(Employee employee) {
        return employees.add(employee);
    }

    public boolean removeEmployee(Employee employee) {
        return employees.remove(employee);
    }
}
