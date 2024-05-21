package com.example.LibrarySystem.StockBrokerageSystem.System3.Account_Member_Admin;

import com.example.LibrarySystem.StockBrokerageSystem.System3.Enum.AccountStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
public abstract class Account {
    private String id;
    private String password;
    private String name;
    private AccountStatus status;
    private Address address;
    private String email;
    private String phone;

    // Login method
    public boolean login(String password) {
        if (this.password.equals(password) && this.status == AccountStatus.ACTIVE) {
            // Perform login actions, e.g., setting session
            System.out.println("Login successful for user: " + name);
            return true;
        }
        System.out.println("Login failed for user: " + name);
        return false;
    }

    // Logout method
    public void logout() {
        // Perform logout actions, e.g., clearing session
        System.out.println("Logout successful for user: " + name);
    }

    // Update account details
    public void updateDetails(String name, Address address, String email, String phone) {
        this.name = name;
        this.address = address;
        this.email = email;
        this.phone = phone;
        System.out.println("Details updated for user: " + name);
    }

    // Change password
    public boolean changePassword(String oldPassword, String newPassword) {
        if (this.password.equals(oldPassword)) {
            this.password = newPassword;
            System.out.println("Password changed successfully for user: " + name);
            return true;
        }
        System.out.println("Password change failed for user: " + name);
        return false;
    }

    // Deactivate account
    public void deactivateAccount() {
        this.status = AccountStatus.CLOSED;
        System.out.println("Account deactivated for user: " + name);
    }
}
