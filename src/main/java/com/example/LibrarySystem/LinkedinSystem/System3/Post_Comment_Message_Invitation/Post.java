package com.example.LibrarySystem.LinkedinSystem.System3.Post_Comment_Message_Invitation;

import com.example.LibrarySystem.LinkedinSystem.System3.Person_Admin_User.User;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Post {
    private int postId;
    private User postOwner;
    private String text;
    private List<Byte> media;
    private int totalReacts;
    private int totalShares;
    private List<Comment> comments = new ArrayList<>();

    public Post(int postId, User postOwner, String text, List<Byte> media) {
        this.postId = postId;
        this.postOwner = postOwner;
        this.text = text;
        this.media = media;
        this.totalReacts = 0;
        this.totalShares = 0;
    }

    public boolean updateText(String newText) {
        this.text = newText;
        return true;
    }

    public boolean addComment(Comment comment) {
        return comments.add(comment);
    }

    public boolean removeComment(Comment comment) {
        return comments.remove(comment);
    }

    public boolean addMedia(Byte mediaItem) {
        return media.add(mediaItem);
    }

    public boolean removeMedia(Byte mediaItem) {
        return media.remove(mediaItem);
    }

    public void incrementReacts() {
        this.totalReacts++;
    }

    public void incrementShares() {
        this.totalShares++;
    }

}
