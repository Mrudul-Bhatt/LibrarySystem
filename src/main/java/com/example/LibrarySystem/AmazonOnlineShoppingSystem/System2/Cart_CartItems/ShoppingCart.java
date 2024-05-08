package com.example.LibrarySystem.AmazonOnlineShoppingSystem.System2.Cart_CartItems;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ShoppingCart {
    private int totalPrice;
    private List<CartItem> cartItems;

    public boolean addItem(CartItem item) {
        this.cartItems.add(item);
        totalPrice = totalPrice + item.getPrice();
        return true;
    }

    public boolean removeItem(CartItem item) {

    }

    public boolean checkout();
}
