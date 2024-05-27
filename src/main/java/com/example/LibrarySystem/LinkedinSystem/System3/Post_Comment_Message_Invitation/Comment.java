package com.example.LibrarySystem.LinkedinSystem.System3.Post_Comment_Message_Invitation;

import com.example.LibrarySystem.LinkedinSystem.System3.Person_Admin_User.User;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Comment {
    private int commentId;
    private User commentOwner;
    private String text;
    private int totalReacts;
    private List<Comment> comments = new ArrayList<>();
    private Post parentPost;
    private Comment parentComment;

    public Comment(int commentId, User commentOwner, String text, Comment parentComment) {
        this.commentId = commentId;
        this.commentOwner = commentOwner;
        this.text = text;
        this.parentComment = parentComment;
        this.totalReacts = 0;
    }

    public boolean updateText(String newText) {
        this.text = newText;
        return true;
    }

    public boolean addReply(Comment comment) {
        return comments.add(comment);
    }

    public boolean removeReply(Comment comment) {
        return comments.remove(comment);
    }

    public void incrementReacts() {
        this.totalReacts++;
    }

}
