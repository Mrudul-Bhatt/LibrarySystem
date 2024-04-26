package com.example.LibrarySystem.ChessGameSystem.System3.Acc_Player_Admin_Person;

import com.example.LibrarySystem.ChessGameSystem.System3.Enum.AccountStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Account {
    private int id;
    private String password;
    private AccountStatus status;

    public Account(int id) {
        this.id = id;
        status = AccountStatus.ACTIVE;
    }

//    public boolean resetPassword()
}
