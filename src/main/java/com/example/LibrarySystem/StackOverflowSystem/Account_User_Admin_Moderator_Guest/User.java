package com.example.LibrarySystem.StackOverflowSystem.Account_User_Admin_Moderator_Guest;

import com.example.LibrarySystem.StackOverflowSystem.Badge_Tag_TagList.Badge;
import com.example.LibrarySystem.StackOverflowSystem.Badge_Tag_TagList.Tag;
import com.example.LibrarySystem.StackOverflowSystem.Question_Answer_Comment_Bounty.Answer;
import com.example.LibrarySystem.StackOverflowSystem.Question_Answer_Comment_Bounty.Comment;
import com.example.LibrarySystem.StackOverflowSystem.Question_Answer_Comment_Bounty.Question;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class User {
    private int reputationPoints;
    private Account account;
    private List<Badge> badges;

    public boolean createQuestion(Question question);

    public boolean addAnswer(Question question, Answer answer);

    public boolean createComment(Comment comment);

    public boolean createTag(Tag tag);

    public void flagQuestion(Question question);

    public void flagAnswer(Answer answer);

    public void upvote(int id);

    public void downvote(int id);

    public void voteToCloseQuestion(Question question);

    public void voteToDeleteQuestion(Question question);

    public void acceptAnswer(Answer answer);
}
