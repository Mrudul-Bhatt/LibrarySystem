package com.example.LibrarySystem.FacebookSystem.System3.Address_Acc_Person_User_Admin;

import com.example.LibrarySystem.FacebookSystem.System3.Enums.AccountStatus;
import com.example.LibrarySystem.FacebookSystem.System3.Group_GroupFunctions.Group;
import com.example.LibrarySystem.FacebookSystem.System3.Page_Post_Comment.Page;
import com.example.LibrarySystem.FacebookSystem.System3.Search_SearchCatalogue.SearchCatalogue;

public class Admin {
    public void blockUser(User user) {
        user.getAccount().setStatus(AccountStatus.BLOCKED);
    }

    public void unblockUser(User user) {
        user.getAccount().setStatus(AccountStatus.ACTIVE);
    }

    public void enablePage(Page page) {
        page.setDisabled(false);
    }

    public void disablePage(Page page) {
        page.setDisabled(true);
    }

    public void deleteGroup(Group group, SearchCatalogue searchCatalogue) {
        searchCatalogue.removeGroup(group);
    }

    public void changeGroupPrivacy(Group group, boolean isPrivate) {
        group.setPrivate(isPrivate);
    }
}
