package com.example.LibrarySystem.StockBrokerageSystem.System3.Search_StockInventory;

import com.example.LibrarySystem.StockBrokerageSystem.System3.Watchlist_Stock.Stock;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class StockInventory implements Search {
    private String inventoryName;
    private Date lastUpdate;
    private HashMap<String, Stock> stockMap = new HashMap<>(); // Map to store stocks by their symbol

    public StockInventory(String inventoryName) {
        this.inventoryName = inventoryName;
        this.lastUpdate = new Date();
    }

    // Add a new stock to the inventory
    public boolean addStock(Stock stock) {
        if (stockMap.containsKey(stock.getSymbol())) {
            return false; // Stock already exists
        }
        stockMap.put(stock.getSymbol(), stock);
        updateLastUpdate();
        return true;
    }

    // Remove a stock from the inventory
    public boolean removeStock(String symbol) {
        if (!stockMap.containsKey(symbol)) {
            return false; // Stock does not exist
        }
        stockMap.remove(symbol);
        updateLastUpdate();
        return true;
    }

    // Update the price of an existing stock
    public boolean updateStockPrice(String symbol, double newPrice) {
        Stock stock = stockMap.get(symbol);
        if (stock == null) {
            return false; // Stock does not exist
        }
        stock.updatePrice(newPrice);
        updateLastUpdate();
        return true;
    }

    // Search for a stock by its symbol
    @Override
    public Stock searchSymbol(String symbol) {
        return stockMap.get(symbol);
    }

    // Search for stocks by their name (assuming Stock has a getName method)
    public List<Stock> searchByName(String name) {
        List<Stock> result = new ArrayList<>();
        for (Stock stock : stockMap.values()) {
            if (stock.getSymbol().equalsIgnoreCase(name)) {
                result.add(stock);
            }
        }
        return result;
    }

    // Retrieve a list of all stocks in the inventory
    public List<Stock> getAllStocks() {
        return new ArrayList<>(stockMap.values()); // Return a copy to avoid external modification
    }

    // Private method to update the last update time
    private void updateLastUpdate() {
        this.lastUpdate = new Date();
    }

}
