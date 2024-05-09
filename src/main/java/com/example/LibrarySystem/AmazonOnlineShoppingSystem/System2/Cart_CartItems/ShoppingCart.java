package com.example.LibrarySystem.AmazonOnlineShoppingSystem.System2.Cart_CartItems;

import com.example.LibrarySystem.AmazonOnlineShoppingSystem.System2.Product_Category_Review.Product;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ShoppingCart {
    private int totalPrice;
    private List<CartItem> cartItems;

    public boolean addItem(Product product, int quantity) {
        // Check if the product already exists in the cart
        for (CartItem item : cartItems) {
            if (item.getProduct().equals(product)) {
                item.setQuantity(item.getQuantity() + quantity);
                updateTotalPrice();
                return true;
            }
        }
        // If the product is not in the cart, add a new item
        CartItem newItem = new CartItem(product, quantity);
        cartItems.add(newItem);
        updateTotalPrice();
        return true;
    }

    public boolean removeItem(Product product) {
        for (CartItem item : cartItems) {
            if (item.getProduct().equals(product)) {
                cartItems.remove(item);
                updateTotalPrice();
                return true;
            }
        }
        return false; // Product not found in the cart
    }

    public boolean updateQuantity(Product product, int newQuantity) {
        for (CartItem item : cartItems) {
            if (item.getProduct().equals(product)) {
                item.setQuantity(newQuantity);
                updateTotalPrice();
                return true;
            }
        }
        return false; // Product not found in the cart
    }

    public boolean checkout() {
        // Implement logic to process checkout
        return true; // Placeholder
    }

    private void updateTotalPrice() {
        int totalPrice = 0;
        for (CartItem item : cartItems) {
            totalPrice += (int) (item.getProduct().getPrice() * item.getQuantity());
        }
        this.totalPrice = totalPrice;
    }
}
