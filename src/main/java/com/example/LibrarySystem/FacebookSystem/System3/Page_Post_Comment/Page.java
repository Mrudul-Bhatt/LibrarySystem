package com.example.LibrarySystem.FacebookSystem.System3.Page_Post_Comment;

import java.util.List;

import com.example.LibrarySystem.FacebookSystem.System3.Address_Acc_Person_User_Admin.User;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class Page {
    private int pageId;
    private String name;
    private String description;
    private int likeCount;
    private boolean isDisabled;
    private User owner;
    private List<User> followers;

    public void incrementLikes() {
        this.likeCount++;
    }

    public void decrementLikes() {
        this.likeCount--;
    }

    public void addFollower(User user) {
        followers.add(user);
    }

    public void removeFollower(User user) {
        followers.remove(user);
    }

}
