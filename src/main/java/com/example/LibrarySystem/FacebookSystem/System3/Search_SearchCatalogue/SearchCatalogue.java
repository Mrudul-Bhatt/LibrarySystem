package com.example.LibrarySystem.FacebookSystem.System3.Search_SearchCatalogue;

import java.util.HashMap;
import java.util.List;

import com.example.LibrarySystem.FacebookSystem.System3.Address_Acc_Person_User_Admin.User;
import com.example.LibrarySystem.FacebookSystem.System3.Group_GroupFunctions.Group;
import com.example.LibrarySystem.FacebookSystem.System3.Page_Post_Comment.Page;
import com.example.LibrarySystem.FacebookSystem.System3.Page_Post_Comment.Post;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class SearchCatalogue implements Search {
    HashMap<String, List<User>> userNames;
    HashMap<String, List<Group>> groupNames;
    HashMap<String, List<Page>> pageTitles;
    HashMap<String, List<Post>> posts;

    public boolean addNewUser(User user) {
    }

    public boolean addNewGroup(Group group) {
    }

    public boolean addNewPage(Page page) {
    }

    public boolean addNewPost(Post post) {
    }

    public List<User> searchUsers(String name) {
        // functionality
    }

    public List<Group> searchGroups(String name) {
        // functionality
    }

    public List<Page> searchPages(String name) {
        // functionality
    }

    public List<Post> searchPosts(String keywords) {
        // functionality
    }
}
