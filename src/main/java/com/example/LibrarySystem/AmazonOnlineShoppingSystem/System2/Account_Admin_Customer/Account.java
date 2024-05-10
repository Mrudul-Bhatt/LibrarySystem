package com.example.LibrarySystem.AmazonOnlineShoppingSystem.System2.Account_Admin_Customer;

import com.example.LibrarySystem.AmazonOnlineShoppingSystem.System2.Enums.AccountStatus;
import com.example.LibrarySystem.AmazonOnlineShoppingSystem.System2.Payment.CreditCard;
import com.example.LibrarySystem.AmazonOnlineShoppingSystem.System2.Payment.ElectronicBankTransfer;
import com.example.LibrarySystem.AmazonOnlineShoppingSystem.System2.Product_Category_Review.Product;
import com.example.LibrarySystem.AmazonOnlineShoppingSystem.System2.Product_Category_Review.ProductReview;
import com.example.LibrarySystem.AmazonOnlineShoppingSystem.System2.Search_Catalogue.Catalogue;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
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
        if (product != null && product.getReviews().contains(review)) {
            return product.getReviews().remove(review);
        }
        return false; // Review not found or product does not exist
    }

    public boolean addShippingAddress(Address address) {
        return shippingAddress.add(address);
    }

    public boolean removeShippingAddress(Address address) {
        return shippingAddress.remove(address);
    }

    public boolean addCreditCard(CreditCard creditCard) {
        return creditCards.add(creditCard);
    }

    public boolean removeCreditCard(CreditCard creditCard) {
        return creditCards.remove(creditCard);
    }

    public boolean addBankAccount(ElectronicBankTransfer bankAccount) {
        return bankAccounts.add(bankAccount);
    }

    public boolean removeBankAccount(ElectronicBankTransfer bankAccount) {
        return bankAccounts.remove(bankAccount);
    }
}
