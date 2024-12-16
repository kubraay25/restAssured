package org.example.test;

import io.restassured.response.Response;
import org.example.apiutils.PetUtils;
import org.example.apiutils.TestData;
import org.example.pojo.Pet;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UpdatePet extends TestData {

    @Test
    public void updatePetPositiveTest(){
        String petName = "fox";
        int petId = 15;
        Pet pet = createPet(petId, petName);
        Response response = PetUtils.putUpdateMethod(pet);
        Assert.assertEquals(response.jsonPath().getString("name"),petName);
        Assert.assertEquals(response.jsonPath().getInt("id"),petId);
        response = PetUtils.getPetMethod(petId);
        Assert.assertEquals(response.jsonPath().getInt("id"), petId);
        Assert.assertEquals(response.jsonPath().getString("name"), petName);
    }

    @Test
    public void updatePetNegativeTest(){
        /**
         * PUT API Update Bug
         * PUT API da normalde olmayan b'r petId ver'ld'ğ'nde 404 hatas' almamız gerekmekted'r. Ancak bu API
         * olmayan ID ver'ld'ğ'nde bu hatayı vermek yer'ne POST create şlem' g'b' o ID de b'r pet oluşturmaktadır.
         * Bu sebeple negat'f senaryo yapılmadı
         */
    }


}





















