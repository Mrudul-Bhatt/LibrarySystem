package com.example.LibrarySystem.RestaurantManagementSystem.Table_TableSeat;

import com.example.LibrarySystem.RestaurantManagementSystem.Enums.TableStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class Table {
    private int tableID;
    private TableStatus status;
    private int maxCapacity;
    private int locationIdentifier;
    private List<TableSeat> seats;

//    public static List<Table> search(int capacity, Date startTime);

//    public boolean isTableFree();

//    public boolean addReservation();
}
