package org.example.test;

import io.restassured.response.Response;
import org.example.apiutils.PetUtils;
import org.example.apiutils.TestData;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.example.pojo.Pet;

public class GetPet extends TestData {

    @Test
    public void getPetPositive() {
        int petId = 600;
        String petName = "bird";
        Pet myPet = createPet(petId, petName);
        PetUtils.postAddMethod(myPet);
        Response response = PetUtils.getPetMethod(petId);
        Assert.assertEquals(response.statusCode(), 200);
        Assert.assertEquals(response.jsonPath().getInt("id"), petId);
        Assert.assertEquals(response.jsonPath().getString("name"), petName);
    }

    @Test
    public void getPetNegative() {
        int petId = 999;
        Response response = PetUtils.getPetMethod(petId);
        Assert.assertEquals(response.statusCode(), 404);
        Assert.assertEquals(response.jsonPath().getString("message"), "Pet not found");
    }
}