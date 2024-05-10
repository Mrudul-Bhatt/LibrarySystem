package com.example.LibrarySystem.StackOverflowSystem.Account_User_Admin_Moderator_Guest;

import com.example.LibrarySystem.StackOverflowSystem.Question_Answer_Comment_Bounty.Answer;
import com.example.LibrarySystem.StackOverflowSystem.Question_Answer_Comment_Bounty.Question;

public class Moderator extends User {
    public void closeQuestion(Question question);

    public void reopenQuestion(Question question);

    public void deleteQuestion(Question question);

    public void restoreQuestion(Question question);

    public void deleteAnswer(Answer answer);
}
