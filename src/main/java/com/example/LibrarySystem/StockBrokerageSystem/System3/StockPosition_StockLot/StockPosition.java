package com.example.LibrarySystem.StockBrokerageSystem.System3.StockPosition_StockLot;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class StockPosition {
    private String symbol;
    private double quantity;
}
