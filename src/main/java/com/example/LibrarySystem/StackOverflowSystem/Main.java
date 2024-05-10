package com.example.LibrarySystem.StackOverflowSystem;

import java.util.ArrayList;
import java.util.Date;

import com.example.LibrarySystem.StackOverflowSystem.Account_User_Admin_Moderator_Guest.Account;
import com.example.LibrarySystem.StackOverflowSystem.Account_User_Admin_Moderator_Guest.User;
import com.example.LibrarySystem.StackOverflowSystem.Enums.AccountStatus;
import com.example.LibrarySystem.StackOverflowSystem.Notification.Notification;
import com.example.LibrarySystem.StackOverflowSystem.Question_Answer_Comment_Bounty.Answer;
import com.example.LibrarySystem.StackOverflowSystem.Question_Answer_Comment_Bounty.Question;

public class Main {
    public static void main(String[] args) {

        // Create accounts for users
        Account account1 = new Account("1", "user1", "password1", "User 1", "user1@example.com", 1234567890,
                AccountStatus.ACTIVE);
        Account account2 = new Account("2", "user2", "password2", "User 2", "user2@example.com", 987654321,
                AccountStatus.ACTIVE);
        Account account3 = new Account("3", "user3", "password3", "User 3", "user3@example.com", 1357924680,
                AccountStatus.ACTIVE);

        // Create users
        User user1 = new User(0, account1, new ArrayList<>());
        User user2 = new User(0, account2, new ArrayList<>());
        User user3 = new User(0, account3, new ArrayList<>());

        user1.setAccount(account1);
        user2.setAccount(account2);
        user3.setAccount(account3);

        // Create questions
        Question question1 = new Question(1, "Question 1", "Content of Question 1", user1);
        Question question2 = new Question(2, "Question 2", "Content of Question 2", user2);

        // Add followers for questions
        question1.addFollower(user2);
        question2.addFollower(user1);

        // Create answers
        Answer answer1 = new Answer(1, "Answer 1", user2);
        Answer answer2 = new Answer(2, "Answer 2", user3);

        // Add followers for answers
        answer1.addFollower(user1);
        answer2.addFollower(user1);

        // Simulate new activity on questions and answers
        Notification notification1 = new Notification(1, new Date(), "New comment on Question 1");
        Notification notification2 = new Notification(2, new Date(), "New answer on Question 2");

        question1.notifyFollowers(notification1);
        question2.notifyFollowers(notification2);

        answer1.notifyFollowers(notification1);
        answer2.notifyFollowers(notification2);
    }
}
