package com.example.LibrarySystem.FacebookSystem.System3.Page_Post_Comment;

import java.util.List;

import com.example.LibrarySystem.FacebookSystem.System3.Address_Acc_Person_User_Admin.User;
import com.example.LibrarySystem.FacebookSystem.System3.Enums.PostPrivacySettings;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Post {
    private int postId;
    private String content;
    private byte[] image;
    private int likeCount;
    private int shareCount;
    private User postOwner;
    private PostPrivacySettings settings;
    private List<Comment> comments;
}
