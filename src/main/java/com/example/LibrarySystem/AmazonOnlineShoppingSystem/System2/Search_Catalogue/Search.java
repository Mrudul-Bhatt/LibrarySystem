package com.example.LibrarySystem.AmazonOnlineShoppingSystem.System2.Search_Catalogue;

import java.util.List;

import com.example.LibrarySystem.AmazonOnlineShoppingSystem.System2.Product_Category_Review.Product;

public interface Search {
    public List<Product> searchProductsByName(String name);

    public List<Product> searchProductsByCategory(String category);
}
