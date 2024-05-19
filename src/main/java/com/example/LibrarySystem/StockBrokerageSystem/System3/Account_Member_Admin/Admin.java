package com.example.LibrarySystem.StockBrokerageSystem.System3.Account_Member_Admin;

import com.example.LibrarySystem.StockBrokerageSystem.System3.Enum.AccountStatus;

public class Admin extends Account {
    public Admin(String id, String password, String name, AccountStatus status, Address address, String email,
                 String phone) {
        super(id, password, name, status, address, email, phone);
    }
    
    // Block a member
    public boolean blockMember(Member member) {
        if (member.getStatus() == AccountStatus.ACTIVE) {
            member.setStatus(AccountStatus.BLACKLISTED);
            System.out.println("Member blocked: " + member.getName());
            return true;
        }
        System.out.println("Failed to block member: " + member.getName());
        return false;
    }

    // Unblock a member
    public boolean unblockMember(Member member) {
        if (member.getStatus() == AccountStatus.BLACKLISTED) {
            member.setStatus(AccountStatus.ACTIVE);
            System.out.println("Member unblocked: " + member.getName());
            return true;
        }
        System.out.println("Failed to unblock member: " + member.getName());
        return false;
    }

    // Cancel membership
    public boolean cancelMembership(Member member) {
        if (member.getStatus() != AccountStatus.CANCELED) {
            member.setStatus(AccountStatus.CANCELED);
            System.out.println("Membership cancelled for member: " + member.getName());
            return true;
        }
        System.out.println("Failed to cancel membership for member: " + member.getName());
        return false;
    }

}
