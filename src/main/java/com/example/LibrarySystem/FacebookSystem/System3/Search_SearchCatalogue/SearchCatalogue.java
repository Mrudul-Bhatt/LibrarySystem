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
        String key = user.getName().toLowerCase();
        if (!userNames.containsKey(key)) {
            userNames.put(key, List.of(user));
            return true;
        } else {
            userNames.get(key).add(user);
            return false;
        }
    }

    public boolean addNewGroup(Group group) {
        String key = group.getName().toLowerCase();
        if (!groupNames.containsKey(key)) {
            groupNames.put(key, List.of(group));
            return true;
        } else {
            groupNames.get(key).add(group);
            return false;
        }
    }

    public boolean addNewPage(Page page) {
        String key = page.getName().toLowerCase();
        if (!pageTitles.containsKey(key)) {
            pageTitles.put(key, List.of(page));
            return true;
        } else {
            pageTitles.get(key).add(page);
            return false;
        }
    }

    public boolean addNewPost(Post post) {
        for (String keyword : post.getContent().toLowerCase().split("\\s+")) {
            if (!posts.containsKey(keyword)) {
                posts.put(keyword, List.of(post));
            } else {
                posts.get(keyword).add(post);
            }
        }
        return true;
    }

    public boolean removeUser(User user) {
        String key = user.getName().toLowerCase();
        List<User> userList = userNames.get(key);
        if (userList != null) {
            return userList.remove(user);
        }
        return false;
    }

    public boolean removeGroup(Group group) {
        String key = group.getName().toLowerCase();
        List<Group> groupList = groupNames.get(key);
        if (groupList != null) {
            return groupList.remove(group);
        }
        return false;
    }

    public boolean removePage(Page page) {
        String key = page.getName().toLowerCase();
        List<Page> pageList = pageTitles.get(key);
        if (pageList != null) {
            return pageList.remove(page);
        }
        return false;
    }

    public boolean removePost(Post post) {
        for (String keyword : post.getContent().toLowerCase().split("\\s+")) {
            List<Post> postList = posts.get(keyword);
            if (postList != null) {
                return postList.remove(post);
            }
        }
        return false;
    }

    @Override
    public List<User> searchUsers(String name) {
        String key = name.toLowerCase();
        return userNames.getOrDefault(key, List.of());
    }

    @Override
    public List<Group> searchGroups(String name) {
        String key = name.toLowerCase();
        return groupNames.getOrDefault(key, List.of());
    }

    @Override
    public List<Page> searchPages(String name) {
        String key = name.toLowerCase();
        return pageTitles.getOrDefault(key, List.of());
    }

    @Override
    public List<Post> searchPosts(String keywords) {
        String key = keywords.toLowerCase();
        return posts.getOrDefault(key, List.of());
    }
}
