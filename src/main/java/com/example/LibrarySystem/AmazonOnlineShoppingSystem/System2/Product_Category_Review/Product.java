package com.example.LibrarySystem.AmazonOnlineShoppingSystem.System2.Product_Category_Review;

public class Product {
    private String productId;
    private String name;
    private String description;
    private byte[] image;
    private double price;
    private ProductCategory category;
    private List<ProductReview> reviews;
    private int availableItemCount;
    
//    private Account account;

    public int getAvailableCount();

    public int updateAvailableCount();

    public boolean updatePrice(double newPrice);
}
