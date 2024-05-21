package com.example.LibrarySystem.StockBrokerageSystem.System3;

import com.example.LibrarySystem.StockBrokerageSystem.System3.Account_Member_Admin.Admin;
import com.example.LibrarySystem.StockBrokerageSystem.System3.Account_Member_Admin.Member;
import com.example.LibrarySystem.StockBrokerageSystem.System3.Enum.TimeEnforcementType;
import com.example.LibrarySystem.StockBrokerageSystem.System3.Notification.Notification;
import com.example.LibrarySystem.StockBrokerageSystem.System3.OrderPart_Order_Limit_StopLimit_StopLoss_Market.LimitOrder;
import com.example.LibrarySystem.StockBrokerageSystem.System3.OrderPart_Order_Limit_StopLimit_StopLoss_Market.MarketOrder;
import com.example.LibrarySystem.StockBrokerageSystem.System3.OrderPart_Order_Limit_StopLimit_StopLoss_Market.OrderPart;
import com.example.LibrarySystem.StockBrokerageSystem.System3.Search_StockInventory.StockInventory;
import com.example.LibrarySystem.StockBrokerageSystem.System3.StockExchange.StockExchange;
import com.example.LibrarySystem.StockBrokerageSystem.System3.StockPosition_StockLot.StockLot;
import com.example.LibrarySystem.StockBrokerageSystem.System3.StockPosition_StockLot.StockPosition;
import com.example.LibrarySystem.StockBrokerageSystem.System3.Transfer_Deposit_Withdraw.DepositMoney;
import com.example.LibrarySystem.StockBrokerageSystem.System3.Watchlist_Stock.Stock;
import com.example.LibrarySystem.StockBrokerageSystem.System3.Watchlist_Stock.Watchlist;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        // Create StockExchange singleton instance
        StockExchange stockExchange = StockExchange.getInstance();

        // Create Admin
        Admin admin = new Admin();
        admin.setId("admin1");
        admin.name = "Admin One";

        // Create Member
        Member member = new Member();
        member.id = "member1";
        member.name = "Member One";
        member.availableFundsForTrading = 10000.0;

        // Create and add stocks to StockInventory
        StockInventory stockInventory = new StockInventory();
        Stock stock1 = new Stock("AAPL", 150.0);
        Stock stock2 = new Stock("GOOG", 2800.0);
        stockInventory.addStock(stock1);
        stockInventory.addStock(stock2);

        // Create Watchlist
        Watchlist techWatchlist = new Watchlist("Tech Stocks");
        techWatchlist.addStock(stock1);
        techWatchlist.addStock(stock2);
        System.out.println("Watchlist: " + techWatchlist.getStocks());

        // Deposit Money
        DepositMoney deposit = new DepositMoney();
        deposit.transactionId = 1;
        deposit.amount = 5000.0;
        deposit.initiateTransaction();
        member.availableFundsForTrading += deposit.amount;

        // Place a Buy Market Order
        MarketOrder buyMarketOrder = new MarketOrder(true, "order1", TimeEnforcementType.GTC);
        buyMarketOrder.addOrderPart(new OrderPart(150.0, 10, new Date()));
        stockExchange.placeOrder(buyMarketOrder);
        member.activeOrders.put(1, buyMarketOrder);

        // Notify Member about the order execution
        Notification notification = Notification.createOrderExecutedNotification(buyMarketOrder.orderNumber);
        notification.sendNotification();

        // Member checks their stock position after the order execution
        StockLot stockLot = new StockLot("lot1", buyMarketOrder);
        StockPosition stockPosition = new StockPosition("AAPL", 10);
        stockPosition.addStockLot(stockLot);
        member.addStockPosition(stockPosition);

        // Print Member's Stock Position
        System.out.println("Stock Position: " + member.getStockPosition("AAPL").getTotalQuantity() + " shares of AAPL");

        // Place a Sell Limit Order
        LimitOrder sellLimitOrder = new LimitOrder(false, "order2", TimeEnforcementType.GTC,
                "AAPL", 5);
        sellLimitOrder.addOrderPart(new OrderPart(155.0, 5, new Date()));
        stockExchange.placeOrder(sellLimitOrder);
        member.activeOrders.put(2, sellLimitOrder);

        // Simulate account status change and notify member
        admin.blockMember(member);
        Notification accountStatusChangeNotification =
                Notification.createAccountStatusChangedNotification(member.id, member.status.name());
        accountStatusChangeNotification.sendNotification();
    }
}
