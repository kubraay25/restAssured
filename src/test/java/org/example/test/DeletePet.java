package org.example.test;

import io.restassured.response.Response;
import org.example.apiutils.PetUtils;
import org.example.apiutils.TestData;
import org.example.pojo.Pet;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DeletePet extends TestData {

    @Test(priority = 1, description = "Delete Pos")
    public void deletePetPositiveTest() {
        int petId = 70;
        String petName = "snake";
        PetUtils.postAddMethod(createPet(petId, petName)); //200
        Response response = PetUtils.deletePetMethod(petId);
        Assert.assertEquals(response.statusCode(), 200);
        Assert.assertEquals(response.jsonPath().getInt("message"), petId);
    }

    @Test(priority = 2)
    public void deletePetNegativeTest() {
        int petId = 70;
        Response response = PetUtils.deletePetMethod(petId);
        Assert.assertEquals(response.statusCode(), 404);
        Assert.assertEquals(response.body().asString(), "");
    }
}