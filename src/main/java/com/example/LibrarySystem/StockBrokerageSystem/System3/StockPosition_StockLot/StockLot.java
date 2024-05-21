package com.example.LibrarySystem.StockBrokerageSystem.System3.StockPosition_StockLot;

import com.example.LibrarySystem.StockBrokerageSystem.System3.OrderPart_Order_Limit_StopLimit_StopLoss_Market.Order;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class StockLot {
    private String lotNumber;
    private Order buyingOrder;
    private double quantity; // Added to track the remaining quantity in the lot
    private double sellingQuantity = 0; // Tracks the quantity sold from this lot

    public StockLot(String lotNumber, Order buyingOrder, double quantity) {
        this.lotNumber = lotNumber;
        this.buyingOrder = buyingOrder;
        this.quantity = quantity;
    }

    // Method to get the buying price of the stock lot
    public double getBuyingPrice() {
        // Assuming Order class has a method to get the average price of all parts
        return buyingOrder.getAveragePrice();
    }

    // Method to get the current value of the stock lot
    public double getCurrentValue(double currentPrice) {
        return (quantity - sellingQuantity) * currentPrice;
    }

    // Method to sell a quantity from the stock lot
    public boolean sell(double sellQuantity) {
        if (sellQuantity <= (quantity - sellingQuantity)) {
            sellingQuantity += sellQuantity;
            return true;
        } else {
            return false;
        }
    }

    // Method to get the remaining quantity in the stock lot
    public double getRemainingQuantity() {
        return quantity - sellingQuantity;
    }
}
