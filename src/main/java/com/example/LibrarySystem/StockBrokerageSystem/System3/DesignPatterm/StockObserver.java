package com.example.LibrarySystem.StockBrokerageSystem.System3.DesignPatterm;

import com.example.LibrarySystem.StockBrokerageSystem.System3.Watchlist_Stock.Stock;

public interface StockObserver {
    void update(Stock stock);
}
