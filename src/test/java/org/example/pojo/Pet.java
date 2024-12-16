package org.example.pojo;

import java.util.ArrayList;

public class Pet {
    public String name;
    public ArrayList<String> photoUrls;
    public int id;
    public Category category;
    public ArrayList<Tag> tags;
    public String status;

    public Pet(String name, ArrayList<String> photoUrls, int id, Category category, ArrayList<Tag> tags, String status)
    {
        this.name = name;
        this.photoUrls = photoUrls;
        this.id= id;
        this.category = category;
        this.tags = tags;
        this.status = status;
    }
}
