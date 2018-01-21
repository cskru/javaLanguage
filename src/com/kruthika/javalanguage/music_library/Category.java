package com.kruthika.javalanguage.music_library;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class Category {
    private String name;
    private UUID id;
    private StringBuilder optionalDescription = new StringBuilder();

    public static Set<Category> categorySet = new HashSet<>();

    {// Initialization block
        optionalDescription.append("Default category description");
    }

    public Category(String name) {
        //Constructor
        this.name = name;
        this.id = UUID.randomUUID();
        addToCategoryList(this);
    }

    public Category(String name, StringBuilder optionalDescription) {
        //Constructor
        this.name = name;
        this.id = UUID.randomUUID();
        this.optionalDescription = optionalDescription;
        addToCategoryList(this);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UUID getId() {
        return id;
    }

    public Set<Category> getCategoryList() {
        return categorySet;
    }

    private void addToCategoryList(Category c) {
        categorySet.add(c);
    }

    @Override
    public String toString() {
        return "Category{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", optionalDescription=" + optionalDescription +
                '}';
    }

    public Set getTracks(TrackType type) {
        Set<UUID> set = new HashSet<>();
        if(type == TrackType.AUDIO) {
            AudioTrack.audioTrackList.forEach((trackId,categoryId) -> {
                if(categoryId == this.id) {
                    set.add(trackId);
                }
            });
            return set;
        }
        return set;
    }
}
