package com.example.LibrarySystem.StackOverflowSystem.Account_User_Admin_Moderator_Guest;

import com.example.LibrarySystem.StackOverflowSystem.Badge_Tag_TagList.Badge;
import com.example.LibrarySystem.StackOverflowSystem.Badge_Tag_TagList.Tag;
import com.example.LibrarySystem.StackOverflowSystem.Badge_Tag_TagList.TagList;
import com.example.LibrarySystem.StackOverflowSystem.Notification.Notification;
import com.example.LibrarySystem.StackOverflowSystem.Observer_Observable_DP.Observer;
import com.example.LibrarySystem.StackOverflowSystem.Question_Answer_Comment_Bounty.Answer;
import com.example.LibrarySystem.StackOverflowSystem.Question_Answer_Comment_Bounty.Comment;
import com.example.LibrarySystem.StackOverflowSystem.Question_Answer_Comment_Bounty.Question;
import com.example.LibrarySystem.StackOverflowSystem.Search_SearchCatalogue.SearchCatalogue;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class User implements Observer {
    private int reputationPoints;
    private Account account;
    private List<Badge> badges;

    // SearchCatalogue should be singleton as it should have only 1 instance across
    // the system
    public boolean createQuestion(Question question, SearchCatalogue searchCatalogue) {
        if (question != null && searchCatalogue != null) {
            // Add the question to the SearchCatalogue for indexing
            searchCatalogue.indexQuestion(question);
            return true;
        }
        return false;
    }

    @Override
    public void update(Notification notification) {
        // Logic to handle the notification received by the user

        System.out.println("Hi, you have a new notification");
        System.out.println(notification.getContent());
    }

    public boolean addAnswer(Question question, Answer answer) {
        question.addAnswer(answer);
        return true;
    }

    public boolean createCommentOnQuestion(Comment comment, Question question) {
        question.addComment(comment);
        return true;
    }

    public boolean createCommentOnQuestion(Comment comment, Answer answer) {
        answer.addComment(comment);
        return true;
    }

    public boolean createTag(Tag tag, TagList tagList) {
        if (tagList != null) {
            tagList.incrementTagCount(tag);
            return true;
        }
        return false;
    }

    public void flagQuestion(Question question) {
        question.incrementFlagCount();
    }

    public void flagAnswer(Answer answer) {
        answer.incrementFlagCount();
    }

    public void upvoteAnswer(Answer answer) {
        answer.upVote();
    }

    public void downvoteAnswer(Answer answer) {
        answer.downVote();
    }

    public void upvoteQuestion(Question question) {
        question.upVote();
    }

    public void downvoteQuestion(Question question) {
        question.downVote();
    }

    public void voteToCloseQuestion(Question question) {
        question.downVote();
    }

    public void voteToDeleteQuestion(Question question) {
        question.downVote();
    }

    public void acceptAnswer(Answer answer) {
        answer.isAccepted();
    }
}
