package com.example.LibrarySystem.StockBrokerageSystem.System3.Transfer_Deposit_Withdraw;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Check extends TransferMoney {
    private String checkNumber;

    public boolean initiateTransaction() {
        // definition
    }
}
