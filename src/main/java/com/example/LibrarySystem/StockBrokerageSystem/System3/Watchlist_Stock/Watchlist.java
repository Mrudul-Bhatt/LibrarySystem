package com.example.LibrarySystem.StockBrokerageSystem.System3.Watchlist_Stock;

import com.example.LibrarySystem.StockBrokerageSystem.System3.DesignPatterm.StockObserver;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class Watchlist implements StockObserver {
    private String name;
    private List<Stock> stocks = new ArrayList<>();

    public Watchlist(String name) {
        this.name = name;
    }

    // Method to add a stock to the watchlist
    public void addStock(Stock stock) {
        if (!stocks.contains(stock)) {
            stocks.add(stock);
            stock.addObserver(this); // Add this watchlist as an observer to the stock
        }
    }

    // Method to remove a stock from the watchlist
    public void removeStock(Stock stock) {
        if (stocks.contains(stock)) {
            stocks.remove(stock);
            stock.removeObserver(this); // Remove this watchlist as an observer from the stock
        }
    }

    // Method to check if a stock is in the watchlist
    public boolean containsStock(Stock stock) {
        return stocks.contains(stock);
    }

    // Method to get the list of stocks in the watchlist
    public List<Stock> getStocks() {
        return new ArrayList<>(stocks); // Return a copy to avoid external modification
    }

    // Method called when a stock's price is updated
    @Override
    public void update(Stock stock) {
        // Perform actions when a stock's price changes
        System.out.println("Stock " + stock.getSymbol() + " updated to " + stock.getPrice());
    }
}
