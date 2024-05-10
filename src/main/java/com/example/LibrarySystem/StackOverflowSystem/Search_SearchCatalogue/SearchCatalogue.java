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
    // private HashMap<String, List<Tag>> questionsUsingTags;
    // private HashMap<String, List<User>> questionsUsingUsers;
    // private HashMap<String, List<String>> questionsUsingWords;

    private HashMap<String, List<Question>> questionsUsingTags;
    private HashMap<String, List<Question>> questionsUsingUsers;
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
        questionsUsingUsers.get(username).add(question);

        // Index question by words in title and content
        String[] words = question.getTitle().split("\\s+"); // Split by whitespace
        for (String word : words) {
            questionsUsingWords.putIfAbsent(word, new ArrayList<>());
            questionsUsingWords.get(word).add(question);
        }
    }

    public void removeQuestion(Question question) {
        removeQuestionByTags(question);
        removeQuestionByUsers(question);
        removeQuestionByWords(question);
    }

    private void removeQuestionByTags(Question question) {
        // Remove the question from the search index based on its tags
        List<Tag> tags = question.getTags();
        for (Tag tag : tags) {
            List<Question> questions = questionsUsingTags.get(tag.getName());
            if (questions != null) {
                questions.remove(question);
            }
        }
    }

    private void removeQuestionByUsers(Question question) {
        // Remove the question from the search index based on its user
        User user = question.getCreatedBy();
        if (user != null) {
            List<Question> questions = questionsUsingUsers.get(user.getAccount().getUsername());
            if (questions != null) {
                questions.remove(question);
            }
        }
    }

    private void removeQuestionByWords(Question question) {
        // Remove the question from the search index based on words in its title and
        // content
        String[] words = question.getTitle().split("\\s+");
        for (String word : words) {
            List<Question> questions = questionsUsingWords.get(word);
            if (questions != null) {
                questions.remove(question);
            }
        }
    }

    public List<Question> searchByTags(String tagName) {
        return questionsUsingTags.getOrDefault(tagName, new ArrayList<>());
    }

    public List<Question> searchByUsers(String username) {
        return questionsUsingUsers.getOrDefault(username, new ArrayList<>());
    }

    public List<Question> searchByWords(String word) {
        return questionsUsingWords.getOrDefault(word, new ArrayList<>());
    }
}
