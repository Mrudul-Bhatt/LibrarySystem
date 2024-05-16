package com.example.LibrarySystem.FacebookSystem.System3.Group_GroupFunctions;

import com.example.LibrarySystem.FacebookSystem.System3.Address_Acc_Person_User_Admin.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class Group implements GroupFunctions {
    private int groupId;
    private String name;
    private String description;
    private byte[] coverPhoto;
    private int totalUsers;
    private boolean isPrivate;
    private List<User> users;

    public boolean addUser(User user) {
        users.add(user);
        totalUsers++;
        return true;
    }

    public boolean deleteUser(User user) {
        users.remove(user);
        totalUsers--;
        return true;
    }

    public boolean notifyUser(User user) {
        // functionality
    }
}
