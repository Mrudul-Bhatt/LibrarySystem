package com.example.LibrarySystem.RestaurantManagementSystem.SeatingChart_Branch_Restaurant;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class Restaurant {
    private String name;
    private List<Branch> branches;

    public boolean addBranch(Branch branch) {
        if (branch == null) {
            return false; // Cannot add null branch
        }
        if (branches == null) {
            branches = new ArrayList<>();
        }
        return branches.add(branch);
    }
}
