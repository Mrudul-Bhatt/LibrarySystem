package com.example.LibrarySystem.RestaurantManagementSystem.Table_TableSeat;

import com.example.LibrarySystem.RestaurantManagementSystem.Enums.SeatType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class TableSeat {
    private int tableSeatNumber;
    private SeatType type;
}
