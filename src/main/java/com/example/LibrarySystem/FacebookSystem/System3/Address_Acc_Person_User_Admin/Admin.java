package com.example.LibrarySystem.FacebookSystem.System3.Address_Acc_Person_User_Admin;

import com.example.LibrarySystem.FacebookSystem.System3.Group_GroupFunctions.Group;
import com.example.LibrarySystem.FacebookSystem.System3.Page_Post_Comment.Page;

public class Admin {
    public void blockUser(User user);

    public void unblockUser(User user);

    public void enablePage(Page page);

    public void disablePage(Page page);

    public void deleteGroup(Group group);

    public void changeGroupPrivacy(Group group);
}
