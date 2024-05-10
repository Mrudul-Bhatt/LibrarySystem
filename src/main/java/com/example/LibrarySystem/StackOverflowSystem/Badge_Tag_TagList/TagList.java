package com.example.LibrarySystem.StackOverflowSystem.Badge_Tag_TagList;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;

@Getter
@Setter
public class TagList {
    private HashMap<Tag, Integer> tagsCount;

    public void incrementTagCount();

    public void decrementTagCount();
}
