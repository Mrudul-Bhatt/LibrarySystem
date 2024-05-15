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
        // functionality
    }

    public boolean deleteUser(User user) {
        // functionality
    }

    public boolean notifyUser(User user) {
        // functionality
    }

    public void updateDescription(String description) {
    }

    public void addCoverPhoto(byte[] image) {
    }
}
