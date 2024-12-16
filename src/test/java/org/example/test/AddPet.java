package org.example.test;

import io.restassured.response.Response;
import org.example.apiutils.PetUtils;
import org.example.apiutils.TestData;
import org.example.pojo.Pet;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AddPet extends TestData {


    @Test
    public void tc001AddPetPositive() {
        int petId = 1, categoryId = 2;
        String petName = "cat", categoryName = "homePets";
        Pet pet = createPet(petId, petName, categoryId, categoryName);
        Response response = PetUtils.postAddMethod(pet);

        Assert.assertEquals(response.jsonPath().getInt("id"), petId);
        Assert.assertEquals(response.jsonPath().getInt("category.id"), categoryId);
        Assert.assertEquals(response.jsonPath().getString("name"), petName);
        Assert.assertEquals(response.jsonPath().getString("category.name"), categoryName);

        response = PetUtils.getPetMethod(petId);
        Assert.assertEquals(response.statusCode(), 200);
    }

    @Test
    public void tc002AddPetNegative() {
        Response response = PetUtils.postAddMethodNegatve();

        Assert.assertEquals(response.statusCode(),405);
        Assert.assertEquals(response.jsonPath().getString("message"), "no data");
    }

}
