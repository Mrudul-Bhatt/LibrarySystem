package com.example.LibrarySystem.AmazonOnlineShoppingSystem.System2.Cart_CartItems;

import java.util.List;

public class ShoppingCart {
    private int totalPrice;
    private List<CartItem> items;

    public boolean addItem(CartItem item);

    public boolean removeItem(CartItem item);

    public List<CartItem> getItems();

    public boolean checkout();
}
