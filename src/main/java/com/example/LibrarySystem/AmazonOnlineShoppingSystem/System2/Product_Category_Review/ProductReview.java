package com.example.LibrarySystem.AmazonOnlineShoppingSystem.System2.Product_Category_Review;

import java.util.ArrayList;
import java.util.List;

import com.example.LibrarySystem.AmazonOnlineShoppingSystem.System2.Account_Admin_Customer.AuthenticatedUser;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductReview {
    private int rating;
    private String review;
    private byte[] image;
    private AuthenticatedUser user;

    // public static double calculateAverageRating(List<ProductReview> reviews) {
    // if (reviews.isEmpty()) {
    // return 0.0;
    // }
    // int totalRating = 0;
    // for (ProductReview review : reviews) {
    // totalRating += review.getRating();
    // }
    // return (double) totalRating / reviews.size();
    // }

    // public List<ProductReview> filterReviewsByRating(int minRating, int
    // maxRating) {
    // List<ProductReview> filteredReviews = new ArrayList<>();
    // for (ProductReview review : reviews) {
    // if (review.getRating() >= minRating && review.getRating() <= maxRating) {
    // filteredReviews.add(review);
    // }
    // }
    // return filteredReviews;
    // }
}
