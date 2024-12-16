package org.example.pojo;

import java.util.ArrayList;

public class Pet {
    public int id;
    public String name;
    public Category category;
    public ArrayList<Tag> tags;
    public ArrayList<String> photoUrls;
    public String status;

    public Pet(String name, ArrayList<String> photoUrls, int id, Category category, ArrayList<Tag> tags, String status) {
        this.id = id;
        this.name = name;
        this.photoUrls = photoUrls;
        this.category = category;
        this.tags = tags;
        this.status = status;
    }
}
