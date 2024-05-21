package com.example.LibrarySystem.StockBrokerageSystem.System3.StockPosition_StockLot;

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
public class StockPosition {
    private String symbol;
    private double totalQuantity; // Updated to track the total quantity of the stock
    private List<StockLot> stockLots = new ArrayList<>(); // Track all the lots of this stock

    public StockPosition(String symbol) {
        this.symbol = symbol;
        this.totalQuantity = 0;
    }

    // Method to add a stock lot to the position
    public void addStockLot(StockLot lot) {
        stockLots.add(lot);
        totalQuantity += lot.getRemainingQuantity();
    }

    // Method to sell a quantity of the stock from the position
    public boolean sellStock(double quantityToSell) {
        double remainingToSell = quantityToSell;
        for (StockLot lot : stockLots) {
            double lotRemainingQuantity = lot.getRemainingQuantity();
            if (lotRemainingQuantity >= remainingToSell) {
                lot.sell(remainingToSell);
                totalQuantity -= remainingToSell;
                return true;
            } else {
                lot.sell(lotRemainingQuantity);
                remainingToSell -= lotRemainingQuantity;
                totalQuantity -= lotRemainingQuantity;
            }
        }
        return false; // Not enough stock to sell
    }

    // Method to get the total value of the stock position
    public double getTotalValue(double currentPrice) {
        double totalValue = 0;
        for (StockLot lot : stockLots) {
            totalValue += lot.getCurrentValue(currentPrice);
        }
        return totalValue;
    }
    
    // Method to get a summary of all stock lots
    public List<String> getStockLotsSummary() {
        List<String> summary = new ArrayList<>();
        for (StockLot lot : stockLots) {
            summary.add("Lot: " + lot.getLotNumber() + ", Remaining Quantity: " + lot.getRemainingQuantity() +
                    ", Buying Price: " + lot.getBuyingPrice());
        }
        return summary;
    }
}
