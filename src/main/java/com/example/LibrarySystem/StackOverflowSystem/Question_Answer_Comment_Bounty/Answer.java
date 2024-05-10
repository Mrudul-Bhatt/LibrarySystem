package com.example.LibrarySystem.StackOverflowSystem.Question_Answer_Comment_Bounty;

import com.example.LibrarySystem.StackOverflowSystem.Account_User_Admin_Moderator_Guest.User;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
public class Answer {
    private int id;
    private String content;
    private int flagCount;
    private int voteCount;
    private int upVotes;
    private int downVotes;
    private boolean isAccepted;
    private Date creationTime;
    private User postedBy;

    private List<Comment> comments;
    private List<User> followers;

    public Answer(int id, String content, User postedBy) {
        this.id = id;
        this.content = content;
        this.flagCount = 0;
        this.voteCount = 0;
        this.upVotes = 0;
        this.downVotes = 0;
        this.isAccepted = false;
        this.creationTime = new Date();
        this.postedBy = postedBy;
        this.comments = new ArrayList<>();
        this.followers = new ArrayList<>();
    }

    public void addComment(Comment comment) {
        comments.add(comment);
    }

    public void removeComment(Comment comment) {
        comments.remove(comment);
    }

    public void addFollower(User follower) {
        followers.add(follower);
    }

    public void removeFollower(User follower) {
        followers.remove(follower);
    }

    public void upVote() {
        upVotes++;
        voteCount++;
    }

    public void downVote() {
        downVotes++;
        voteCount++;
    }

    public void incrementFlagCount() {
        flagCount++;
    }

}
