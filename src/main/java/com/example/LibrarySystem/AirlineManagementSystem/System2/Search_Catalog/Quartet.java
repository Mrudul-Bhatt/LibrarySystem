package com.example.LibrarySystem.AirlineManagementSystem.System2.Search_Catalog;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Quartet<A, B, C, D> {
    private final A first;
    private final B second;
    private final C third;
    private final D fourth;

    public Quartet(A first, B second, C third, D fourth) {
        this.first = first;
        this.second = second;
        this.third = third;
        this.fourth = fourth;
    }

}
