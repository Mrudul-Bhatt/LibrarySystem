package com.example.LibrarySystem.AmazonOnlineShoppingSystem.System2.Product_Category_Review;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product {
    private String productId;
    private String name;
    private String description;
    private byte[] image;
    private double price;
    private ProductCategory category;
    private List<ProductReview> reviews;
    private int availableItemCount;

    public void updateAvailability(int quantitySold) {
        availableItemCount -= quantitySold;
    }

    public boolean validateProductData() {
        // Implement validation logic
        return true; // Placeholder
    }

    public double calculateAverageRating() {
        // Calculate the average rating of the product based on customer reviews
        double sum = 0;
        for (ProductReview review : reviews) {
            sum += review.getRating();
        }
        return reviews.isEmpty() ? 0 : sum / reviews.size();
    }
}
