package com.example.LibrarySystem.FacebookSystem.System3.Page_Post_Comment;

import com.example.LibrarySystem.FacebookSystem.System3.Address_Acc_Person_User_Admin.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Comment {
    private int commentId;
    private String content;
    private int likeCount;
    private User commentOwner;
}
