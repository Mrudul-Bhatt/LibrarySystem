package com.example.LibrarySystem.RestaurantManagementSystem.Address_Account_Person_Customer_Employee;

import com.example.LibrarySystem.RestaurantManagementSystem.SeatingChart_Branch_Restaurant.Branch;

public class Manager extends Employee {
    public Manager(String name, String email, String phone) {
        super(name, email, phone);
    }

    public boolean addEmployee(Employee employee, Branch branch) {
        return branch.addEmployee(employee);
    }

}
