package com.example.LibrarySystem.StockBrokerageSystem.System3.Watchlist_Stock;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class Stock {
    private String symbol;
    private double price;
}
