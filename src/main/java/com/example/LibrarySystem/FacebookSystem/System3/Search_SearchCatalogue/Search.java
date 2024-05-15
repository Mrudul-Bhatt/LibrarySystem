package com.example.LibrarySystem.FacebookSystem.System3.Search_SearchCatalogue;

import java.util.List;

import com.example.LibrarySystem.FacebookSystem.System3.Address_Acc_Person_User_Admin.User;
import com.example.LibrarySystem.FacebookSystem.System3.Group_GroupFunctions.Group;
import com.example.LibrarySystem.FacebookSystem.System3.Page_Post_Comment.Page;
import com.example.LibrarySystem.FacebookSystem.System3.Page_Post_Comment.Post;

public interface Search {
    public List<User> searchUsers(String name);

    public List<Group> searchGroups(String name);

    public List<Page> searchPages(String name);

    public List<Post> searchPosts(String keywords);
}
