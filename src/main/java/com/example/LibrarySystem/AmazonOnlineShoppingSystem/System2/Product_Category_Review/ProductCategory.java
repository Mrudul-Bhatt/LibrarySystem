package com.example.LibrarySystem.AmazonOnlineShoppingSystem.System2.Product_Category_Review;

import java.util.Comparator;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductCategory {
    private String name;
    private String description;
    private List<Product> products;

    public void addProduct(Product product) {
        products.add(product);
    }

    public boolean removeProduct(Product product) {
        return products.remove(product);
    }

    public void sortProductsByName() {
        products.sort(Comparator.comparing(Product::getName));
    }

    public void sortProductsByPrice() {
        products.sort(Comparator.comparingDouble(Product::getPrice));
    }
}
