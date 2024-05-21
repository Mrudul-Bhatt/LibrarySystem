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
public class Stock {
    private String symbol;
    private double price;
    private List<Double> priceHistory = new ArrayList<>(); // To track historical prices
    private List<StockObserver> observers = new ArrayList<>(); // For observer pattern

    public Stock(String symbol, double price) {
        this.symbol = symbol;
        this.price = price;
        this.priceHistory.add(price);
    }

    // Method to update the stock price
    public void updatePrice(double newPrice) {
        this.price = newPrice;
        this.priceHistory.add(newPrice);
        notifyObservers();
    }

    // Method to get historical prices
    public List<Double> getPriceHistory() {
        return new ArrayList<>(priceHistory); // Return a copy to avoid external modification
    }

    // Methods for observer pattern
    public void addObserver(StockObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(StockObserver observer) {
        observers.remove(observer);
    }

    private void notifyObservers() {
        for (StockObserver observer : observers) {
            observer.update(this);
        }
    }
}
