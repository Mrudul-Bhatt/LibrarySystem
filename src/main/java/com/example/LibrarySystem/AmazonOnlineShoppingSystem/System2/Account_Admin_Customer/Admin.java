package com.example.LibrarySystem.AmazonOnlineShoppingSystem.System2.Account_Admin_Customer;

import com.example.LibrarySystem.AmazonOnlineShoppingSystem.System2.Enums.AccountStatus;
import com.example.LibrarySystem.AmazonOnlineShoppingSystem.System2.Product_Category_Review.ProductCategory;
import com.example.LibrarySystem.AmazonOnlineShoppingSystem.System2.Search_Catalogue.Catalogue;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Admin {
    private Account account;

    public boolean blockUser(Account userAccount) {
        if (userAccount != null && userAccount.getStatus() != AccountStatus.BLOCKED) {
            userAccount.setStatus(AccountStatus.BLOCKED);
            return true;
        }
        return false; // User account not found or already blocked
    }

    public boolean unblockUser(Account userAccount) {
        if (userAccount != null && userAccount.getStatus() == AccountStatus.BLOCKED) {
            userAccount.setStatus(AccountStatus.ACTIVE);
            return true;
        }
        return false; // User account not found or not blocked
    }

    public boolean addNewProductCategory(ProductCategory category, Catalogue catalogue) {
        return catalogue.addProductCategory(category);
    }

    public boolean modifyProductCategory(ProductCategory category, Catalogue catalogue) {
        return catalogue.editProductCategory(category);
    }

    public boolean deleteProductCategory(ProductCategory category, Catalogue catalogue) {
        return catalogue.deleteProductCategory(category);
    }
}
