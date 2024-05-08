package com.example.LibrarySystem.AmazonOnlineShoppingSystem.System2.Account_Admin_Customer;

import com.example.LibrarySystem.AmazonOnlineShoppingSystem.System2.Enums.AccountStatus;
import com.example.LibrarySystem.AmazonOnlineShoppingSystem.System2.Payment.CreditCard;
import com.example.LibrarySystem.AmazonOnlineShoppingSystem.System2.Payment.ElectronicBankTransfer;
import com.example.LibrarySystem.AmazonOnlineShoppingSystem.System2.Product_Category_Review.Product;
import com.example.LibrarySystem.AmazonOnlineShoppingSystem.System2.Product_Category_Review.ProductReview;
import com.example.LibrarySystem.AmazonOnlineShoppingSystem.System2.Search_Catalogue.Catalogue;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Account {
    private String userName;
    private String password;
    private String name;
    private List<Address> shippingAddress;
    private AccountStatus status;
    private String email;
    private String phone;

    private List<CreditCard> creditCards;
    private List<ElectronicBankTransfer> bankAccounts;

    public Address getShippingAddress() {

    }

    public boolean addProduct(Product product, Catalogue catalogue) {
        return catalogue.addProduct(product);
    }

    public boolean addProductReview(ProductReview review, Product product) {
        return product.getReviews().add(review);
    }

    public boolean deleteProduct(Product product, Catalogue catalogue) {
        return catalogue.deleteProduct(product);
    }

    public boolean deleteProductReview(ProductReview review, Product product) {

    }

    public boolean resetPassword();
}
