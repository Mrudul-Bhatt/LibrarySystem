package com.example.LibrarySystem.StackOverflowSystem.Badge_Tag_TagList;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;

@Getter
@Setter
public class TagList {
    private HashMap<Tag, Integer> tagsCount;

    public TagList() {
        this.tagsCount = new HashMap<>();
    }

    public void incrementTagCount(Tag tag) {
        tagsCount.put(tag, tagsCount.getOrDefault(tag, 0) + 1);
    }

    public void decrementTagCount(Tag tag) {
        int count = tagsCount.getOrDefault(tag, 0);
        if (count > 1) {
            tagsCount.put(tag, count - 1);
        } else {
            tagsCount.remove(tag);
        }
    }
}
