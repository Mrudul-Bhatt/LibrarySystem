package com.example.LibrarySystem.StackOverflowSystem.Account_User_Admin_Moderator_Guest;

import com.example.LibrarySystem.StackOverflowSystem.Badge_Tag_TagList.Badge;
import com.example.LibrarySystem.StackOverflowSystem.Enums.QuestionStatus;
import com.example.LibrarySystem.StackOverflowSystem.Question_Answer_Comment_Bounty.Answer;
import com.example.LibrarySystem.StackOverflowSystem.Question_Answer_Comment_Bounty.Question;
import com.example.LibrarySystem.StackOverflowSystem.Search_SearchCatalogue.SearchCatalogue;

import java.util.List;

public class Moderator extends User {
    public Moderator(int reputationPoints, Account account, List<Badge> badges) {
        super(reputationPoints, account, badges);
    }

    public void closeQuestion(Question question) {
        if (question != null && question.getStatus() != QuestionStatus.CLOSED) {
            question.setStatus(QuestionStatus.CLOSED);
        }
    }

    public void reopenQuestion(Question question) {
        if (question != null && question.getStatus() == QuestionStatus.CLOSED) {
            question.setStatus(QuestionStatus.ACTIVE);
        }
    }

    public void deleteQuestion(Question question, SearchCatalogue searchCatalogue) {
        if (question != null && searchCatalogue != null) {
            searchCatalogue.removeQuestion(question);
        }
    }

    public void deleteAnswer(Answer answer, Question question) {
        if (answer != null) {
            question.removeAnswer(answer);
        }
    }
}
