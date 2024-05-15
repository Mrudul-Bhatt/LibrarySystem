package com.example.LibrarySystem.FacebookSystem.System3.Group_GroupFunctions;

import com.example.LibrarySystem.FacebookSystem.System3.Address_Acc_Person_User_Admin.User;

public interface GroupFunctions {
    public boolean addUser(User user);

    public boolean deleteUser(User user);

    public boolean notifyUser(User user);
}
