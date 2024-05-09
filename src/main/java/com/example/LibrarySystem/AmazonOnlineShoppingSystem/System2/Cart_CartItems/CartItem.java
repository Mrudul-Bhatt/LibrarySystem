package com.example.LibrarySystem.AmazonOnlineShoppingSystem.System2.Cart_CartItems;

import com.example.LibrarySystem.AmazonOnlineShoppingSystem.System2.Product_Category_Review.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CartItem {
    private Product product;
    private int quantity;

    public double getTotalPrice() {
        return product.getPrice() * quantity;
    }

    public boolean updateQuantity(int newQuantity) {
        if (newQuantity > 0) {
            this.quantity = newQuantity;
            return true;
        } else {
            return false; // Invalid quantity
        }
    }
}
