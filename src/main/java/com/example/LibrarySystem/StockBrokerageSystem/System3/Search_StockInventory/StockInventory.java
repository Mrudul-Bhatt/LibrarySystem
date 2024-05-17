package com.example.LibrarySystem.StockBrokerageSystem.System3.Search_StockInventory;

import com.example.LibrarySystem.StockBrokerageSystem.System3.Watchlist_Stock.Stock;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class StockInventory implements Search {
    private String inventoryName;
    private Date lastUpdate;

    public Stock searchSymbol(String symbol) {
        // definition
    }
}
