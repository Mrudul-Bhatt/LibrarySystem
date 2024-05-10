package com.example.LibrarySystem.StackOverflowSystem.Question_Answer_Comment_Bounty;

import com.example.LibrarySystem.StackOverflowSystem.Account_User_Admin_Moderator_Guest.User;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class Comment {
    private int id;
    private String content;
    private int flagCount;
    private int upVotes;
    private Date creationDate;
    private User postedBy;
}
