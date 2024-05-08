package com.example.LibrarySystem.AmazonOnlineShoppingSystem.System2.Account_Admin_Customer;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Admin {
    private Account account;

    public boolean blockUser(Account account);

    public boolean addNewProductCategory(ProductCategory category);

    public boolean modifyProductCategory(ProductCategory category);

    public boolean deleteProductCategory(ProductCategory category);
}
