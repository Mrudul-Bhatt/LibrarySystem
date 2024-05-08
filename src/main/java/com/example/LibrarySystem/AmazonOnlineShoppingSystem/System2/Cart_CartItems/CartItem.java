package com.example.LibrarySystem.AmazonOnlineShoppingSystem.System2.Cart_CartItems;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CartItem {
    private int quantity;
    private int price;

    public boolean updateQuantity(int quantity) {
        this.quantity = quantity;
        return true;
    }
}
