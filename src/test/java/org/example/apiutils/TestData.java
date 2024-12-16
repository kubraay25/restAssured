package org.example.apiutils;

import org.example.pojo.Category;
import org.example.pojo.Pet;
import org.example.pojo.Tag;

import java.util.ArrayList;

public class TestData {

    public Pet createPet(int petId, String petName, int categoryId, String categoryName) {
        Tag tag = new Tag(1, "pet");
        ArrayList<Tag> myTags = new ArrayList<>();
        myTags.add(tag);
        Category category = new Category(categoryId, categoryName);
        ArrayList<String> photoUrls = new ArrayList<>();
        photoUrls.add("http://Urls here");
        Pet pet = new Pet(petName, photoUrls, petId, category, myTags, "available");
        return pet;
    }

    public Pet createPet(int petId, String petName) {
        Tag tag = new Tag(1, "pet");
        ArrayList<Tag> myTags = new ArrayList<>();
        myTags.add(tag);
        Category category = new Category(2, "pets");
        ArrayList<String> photoUrls = new ArrayList<>();
        photoUrls.add("http://Urls here");
        Pet pet = new Pet(petName, photoUrls, petId, category, myTags, "available");
        return pet;
    }
}
