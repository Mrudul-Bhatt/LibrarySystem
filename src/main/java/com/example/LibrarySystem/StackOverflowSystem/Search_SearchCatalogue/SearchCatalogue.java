package com.example.LibrarySystem.StackOverflowSystem.Search_SearchCatalogue;

import com.example.LibrarySystem.StackOverflowSystem.Account_User_Admin_Moderator_Guest.User;
import com.example.LibrarySystem.StackOverflowSystem.Badge_Tag_TagList.Tag;
import com.example.LibrarySystem.StackOverflowSystem.Question_Answer_Comment_Bounty.Question;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Getter
@Setter
public class SearchCatalogue implements Search {
//    private HashMap<String, List<Tag>> questionsUsingTags;
//    private HashMap<String, List<User>> questionsUsingUsers;
//    private HashMap<String, List<String>> questionsUsingWords;

    private HashMap<String, List<Question>> questionsUsingTags;
    private HashMap<String, List<User>> questionsUsingUsers;
    private HashMap<String, List<Question>> questionsUsingWords;

    public SearchCatalogue() {
        this.questionsUsingTags = new HashMap<>();
        this.questionsUsingUsers = new HashMap<>();
        this.questionsUsingWords = new HashMap<>();
    }

    public void indexQuestion(Question question) {
        // Index question by tags
        for (Tag tag : question.getTags()) {
            String tagName = tag.getName();
            questionsUsingTags.putIfAbsent(tagName, new ArrayList<>());
            questionsUsingTags.get(tagName).add(question);
        }

        // Index question by user
        User user = question.getCreatedBy();
        String username = user.getAccount().getUsername();
        questionsUsingUsers.putIfAbsent(username, new ArrayList<>());
        questionsUsingUsers.get(username).add(user);

        // Index question by words in title and content
        String[] words = question.getTitle().split("\\s+"); // Split by whitespace
        for (String word : words) {
            questionsUsingWords.putIfAbsent(word, new ArrayList<>());
            questionsUsingWords.get(word).add(question);
        }
    }

    public List<Question> searchByTags(String tagName) {
        return questionsUsingTags.getOrDefault(tagName, new ArrayList<>());
    }

    public List<Question> searchByUsers(String username) {
        List<Question> result = new ArrayList<>();
        List<User> users = questionsUsingUsers.getOrDefault(username, new ArrayList<>());
        for (User user : users) {
            result.addAll(user.getCreatedQuestions());
        }
        return result;
    }

    public List<Question> searchByWords(String word) {
        return questionsUsingWords.getOrDefault(word, new ArrayList<>());
    }
}
