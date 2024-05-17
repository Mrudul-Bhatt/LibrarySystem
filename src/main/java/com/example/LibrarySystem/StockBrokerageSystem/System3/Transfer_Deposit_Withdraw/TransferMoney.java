package com.example.LibrarySystem.StockBrokerageSystem.System3.Transfer_Deposit_Withdraw;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public abstract class TransferMoney {
    public int fromAccount;
    private int id;
    private Date creationDate;
    private int toAccount;

    public abstract boolean initiateTransaction();
}
