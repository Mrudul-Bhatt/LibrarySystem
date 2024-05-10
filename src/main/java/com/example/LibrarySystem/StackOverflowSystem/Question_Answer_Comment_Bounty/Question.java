package com.example.LibrarySystem.StackOverflowSystem.Question_Answer_Comment_Bounty;

import com.example.LibrarySystem.StackOverflowSystem.Account_User_Admin_Moderator_Guest.User;
import com.example.LibrarySystem.StackOverflowSystem.Badge_Tag_TagList.Tag;
import com.example.LibrarySystem.StackOverflowSystem.Enums.ClosingDetail;
import com.example.LibrarySystem.StackOverflowSystem.Enums.QuestionStatus;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
public class Question {
    private int id;
    private String title;
    private int flagCount;
    private String content;
    private User createdBy;
    private int upVotes;
    private int downVotes;
    private int viewCount;
    private int score;
    private int voteCount;
    private Date creationDate;
    private Date modificationDate;
    private QuestionStatus status;
    private ClosingDetail closingReason;
    private Bounty bounty;

    private List<Tag> tags;
    private List<Comment> comments;
    private List<Answer> answers;
    private List<User> followers;

    public Question(int id, String title, String content, User createdBy) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.createdBy = createdBy;
        this.upVotes = 0;
        this.downVotes = 0;
        this.viewCount = 0;
        this.score = 0;
        this.voteCount = 0;
        this.creationDate = new Date();
        this.modificationDate = new Date();
        this.status = QuestionStatus.ACTIVE;
        this.closingReason = null;
        this.bounty = null;
        this.tags = new ArrayList<>();
        this.comments = new ArrayList<>();
        this.answers = new ArrayList<>();
        this.followers = new ArrayList<>();
    }

    public void addComment(Comment comment) {
        this.comments.add(comment);
    }

    public void removeComment(Comment comment) {
        this.comments.remove(comment);
    }

    public void addAnswer(Answer answer) {
        this.answers.add(answer);
    }

    public void removeAnswer(Answer answer) {
        answers.remove(answer);
    }

    public void addTag(Tag tag) {
        this.tags.add(tag);
    }

    public void removeTag(Tag tag) {
        this.tags.remove(tag);
    }

    public void addFollower(User follower) {
        this.followers.add(follower);
    }

    public void removeFollower(User follower) {
        this.followers.remove(follower);
    }

    public void upVote() {
        this.upVotes++;
        this.voteCount++;
        calculateScore();
    }

    public void downVote() {
        this.downVotes++;
        this.voteCount++;
        calculateScore();
    }

    public void calculateScore() {
        // Score calculation logic based on votes, views, etc.
        this.score = upVotes - downVotes;
    }

    public void close(QuestionStatus status, ClosingDetail reason) {
        this.status = status;
        this.closingReason = reason;
    }

    public void reopen() {
        this.status = QuestionStatus.ACTIVE;
        this.closingReason = null;
    }

    public void addBounty(Bounty bounty) {
        this.bounty = bounty;
    }

    public void removeBounty() {
        this.bounty = null;
    }

    public void incrementFlagCount() {
        flagCount++;
    }

}
