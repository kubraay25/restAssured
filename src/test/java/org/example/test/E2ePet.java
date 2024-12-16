package org.example.test;


import io.restassured.response.Response;
import org.example.apiutils.PetUtils;
import org.example.apiutils.TestData;
import org.example.pojo.Pet;
import org.testng.Assert;
import org.testng.annotations.Test;


public class E2ePet extends TestData {

    @Test
    public void tc001E2ePetStore() {
        String petName = "dog";
        int petId = 99;
        Pet pet = createPet(petId, petName);
        Response response = PetUtils.postAddMethod(pet);
        PetUtils.getPetMethod(petId);
        Assert.assertEquals(response.statusCode(), 200);
        Assert.assertEquals(response.jsonPath().getInt("id"), petId);
        Assert.assertEquals(response.jsonPath().getString("name"), petName);

        petName = "bird";
        petId = 78;
        pet = createPet(petId, petName);
        PetUtils.putUpdateMethod(pet);
        response = PetUtils.getPetMethod(petId);
        Assert.assertEquals(response.statusCode(), 200);
        Assert.assertEquals(response.jsonPath().getInt("id"), petId);
        Assert.assertEquals(response.jsonPath().getString("name"), petName);

        response =PetUtils.deletePetMethod(petId);
        Assert.assertEquals(response.statusCode(),200);
        Assert.assertEquals(response.jsonPath().getInt("message"),petId);





    }
}
