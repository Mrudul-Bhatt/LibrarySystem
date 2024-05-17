package com.example.LibrarySystem.StockBrokerageSystem.System3.StockExchange;

import com.example.LibrarySystem.StockBrokerageSystem.System3.OrderPart_Order_Limit_StopLimit_StopLoss_Market.Order;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class StockExchange {
    // The StockExchange is a singleton class that ensures it will have only one active instance at a time
    private static StockExchange instance = null;

    // Created a private constructor to add a restriction (due to Singleton)
    private StockExchange() {
    }

    // Created a static method to access the singleton instance of StockExchange
    public static StockExchange getInstance() {
        if (instance == null) {
            instance = new StockExchange();
        }
        return instance;
    }

    public boolean placeOrder(Order order);
}
