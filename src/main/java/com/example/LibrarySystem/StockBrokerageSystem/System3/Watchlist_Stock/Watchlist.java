package com.example.LibrarySystem.StockBrokerageSystem.System3.Watchlist_Stock;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class Watchlist {
    private String name;
    private List<Stock> stocks;

    public List<Stock> getStocks();
}
