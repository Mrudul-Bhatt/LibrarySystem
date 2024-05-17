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
}
