package com.example.LibrarySystem.StackOverflowSystem.Search_SearchCatalogue;

import com.example.LibrarySystem.StackOverflowSystem.Question_Answer_Comment_Bounty.Question;

import java.util.List;

public interface Search {
    public List<Question> searchByTags(String name);

    public List<Question> searchByUsers(String name);

    public List<Question> searchByWords(String words);
}
