package com.example.LibrarySystem.StockBrokerageSystem.System3.StockExchange;

import com.example.LibrarySystem.StockBrokerageSystem.System3.Enum.OrderStatus;
import com.example.LibrarySystem.StockBrokerageSystem.System3.OrderPart_Order_Limit_StopLimit_StopLoss_Market.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.*;

@Getter
@Setter
@Builder
public class StockExchange {
    // Singleton instance
    private static StockExchange instance = null;
    // Order books for buy and sell orders
    private HashMap<String, List<Order>> buyOrderBook;
    private HashMap<String, List<Order>> sellOrderBook;
    // Map to store current stock prices
    private HashMap<String, Double> stockPrices;

    // Private constructor for singleton
    private StockExchange() {
        // Initialize order books
        buyOrderBook = new HashMap<>();
        sellOrderBook = new HashMap<>();
        stockPrices = new HashMap<>();
    }

    // Method to get the singleton instance
    public static StockExchange getInstance() {
        if (instance == null) {
            instance = new StockExchange();
        }
        return instance;
    }

    // Method to get the current price of a stock
    public double getStockPrice(String stockSymbol) {
        return stockPrices.getOrDefault(stockSymbol, 0.0);
    }

    // Method to create and place a new order
    public boolean createOrder(Order order) {
        if (!validateOrder(order)) {
            return false; // Order validation failed
        }

        // Add order to the appropriate order book
        if (order.isBuyOrder()) {
            buyOrderBook.computeIfAbsent(order.getStockPosition().getSymbol(), k -> new ArrayList<>()).add(order);
        } else {
            sellOrderBook.computeIfAbsent(order.getStockPosition().getSymbol(), k -> new ArrayList<>()).add(order);
        }

        // Attempt to execute the order
        return executeOrder(order);
    }

    // Method to validate an order
    private boolean validateOrder(Order order) {
        return order != null && order.validateOrder();
    }

    // Method to execute an order
    private boolean executeOrder(Order order) {
        double currentPrice = getStockPrice(order.getStockPosition().getSymbol());

        // Handle different types of orders
        if (order instanceof MarketOrder) {
            return ((MarketOrder) order).executeOrder();
        } else if (order instanceof LimitOrder) {
            return ((LimitOrder) order).executeOrder(currentPrice);
        } else if (order instanceof StopLimitOrder) {
            return ((StopLimitOrder) order).executeOrder(currentPrice);
        } else if (order instanceof StopLossOrder) {
            return ((StopLossOrder) order).executeOrder(currentPrice);
        }

        return false;
    }

    // Method to match buy and sell orders
    private void matchOrders(String stockSymbol) {
        List<Order> buyOrders = buyOrderBook.getOrDefault(stockSymbol, new ArrayList<>());
        List<Order> sellOrders = sellOrderBook.getOrDefault(stockSymbol, new ArrayList<>());

        // Sort buy orders by price descending (highest price first)
        buyOrders.sort((o1, o2) -> Double.compare(o2.getTotalPrice(), o1.getTotalPrice()));

        // Sort sell orders by price ascending (lowest price first)
        sellOrders.sort((o1, o2) -> Double.compare(o1.getTotalPrice(), o2.getTotalPrice()));

        // Match orders
        for (Order buyOrder : buyOrders) {
            for (Order sellOrder : sellOrders) {
                if (buyOrder.getTotalPrice() >= sellOrder.getTotalPrice()) {
                    double matchPrice = (buyOrder.getTotalPrice() + sellOrder.getTotalPrice()) / 2;
                    double matchQuantity = Math.min(buyOrder.getTotalQuantity(), sellOrder.getTotalQuantity());

                    // Create order parts for the matched orders
                    OrderPart buyOrderPart = new OrderPart(matchPrice, matchQuantity, new Date());
                    OrderPart sellOrderPart = new OrderPart(matchPrice, matchQuantity, new Date());

                    buyOrder.addOrderPart(buyOrderPart);
                    sellOrder.addOrderPart(sellOrderPart);

                    buyOrder.setStatus(OrderStatus.PARTIALLY_FILLED);
                    sellOrder.setStatus(OrderStatus.PARTIALLY_FILLED);

                    // Update quantities
                    buyOrder.setTotalQuantity(buyOrder.getTotalQuantity() - matchQuantity);
                    sellOrder.setTotalQuantity(sellOrder.getTotalQuantity() - matchQuantity);

                    if (buyOrder.getTotalQuantity() == 0) {
                        buyOrder.setStatus(OrderStatus.FILLED);
                        break;
                    }
                    if (sellOrder.getTotalQuantity() == 0) {
                        sellOrder.setStatus(OrderStatus.FILLED);
                    }
                }
            }
        }
    }
    
    // Method to update stock prices (simulate real-time updates)
    public void updateStockPrices(Map<String, Double> newPrices) {
        stockPrices.putAll(newPrices);
    }

}
