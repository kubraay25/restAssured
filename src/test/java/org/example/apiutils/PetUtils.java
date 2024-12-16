package org.example.apiutils;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.example.pojo.Pet;

import static io.restassured.RestAssured.given;

public class PetUtils {

    public static Response postAddMethod(Pet pet) {
        RestAssured.baseURI = ConfigReader.getProperty("baseuri");
        Response response = given().log().all().header("Content-Type", ContentType.JSON)
                .body(pet)
                .when().post("/pet")
                .then().log().all().assertThat().statusCode(200).extract().response();
        return response;
    }

    public static Response postAddMethodNegatve() {
        RestAssured.baseURI = ConfigReader.getProperty("baseuri");
        Response response = given().log().all().header("Content-Type", ContentType.JSON)
                .body("")
                .when().post("/pet")
                .then().log().all().extract().response();
        return response;
    }

    public static Response putUpdateMethod(Pet pet) {
        RestAssured.baseURI = ConfigReader.getProperty("baseuri");
        Response response = given().log().all().header("Content-Type", ContentType.JSON)
                .body(pet)
                .when().put("/pet")
                .then().log().all().assertThat().statusCode(200).extract().response();
        return response;
    }

    public static Response getPetMethod(int petId) {
        RestAssured.baseURI = ConfigReader.getProperty("baseuri");
        Response response = given().log().all()
                .when().get("/pet/" + petId)
                .then().log().all().extract().response();
        return response;
    }

    public static Response deletePetMethod(int petId) {
        RestAssured.baseURI = ConfigReader.getProperty("baseuri");
        Response response = given().log().all()
                .when().delete("/pet/" + petId)
                .then().log().all().extract().response();
        return response;
    }
}