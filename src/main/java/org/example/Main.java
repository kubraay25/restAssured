package org.example;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.lang.reflect.Type;

import static io.restassured.RestAssured.given;

public class Main {
    public static void main(String[] args) {

        RestAssured.baseURI = "https://petstore.swagger.io/v2";


        Response response = given().log().all().header("Content-Type",ContentType.JSON)
                .body("{\n" +
                        "  \"name\": \"cat\",\n" +
                        "  \"photoUrls\": [\n" +
                        "    \"photoUrls89\"\n" +
                        "  ],\n" +
                        "  \"id\": 111,\n" +
                        "  \"category\": {\n" +
                        "    \"id\": 111,\n" +
                        "    \"name\": \"home\"\n" +
                        "  },\n" +
                        "  \"tags\": [\n" +
                        "    {\n" +
                        "      \"id\": 111,\n" +
                        "      \"name\": \"cats\"\n" +
                        "    }\n" +
                        "  ],\n" +
                        "  \"status\": \"available\"\n" +
                        "}")
                .when().post("/pet").then().log().all()
                .assertThat().statusCode(200).extract().response();

        int id=response.jsonPath().getInt("id");
        System.out.println("ID : "+id);

        response = given().log().all().when().get("/pet/"+id).then().assertThat().statusCode(200).extract().response();



        //response.prettyPrint();

        //öncelikle güncelleyeceğim kısmı burada belirttim
        String updatePetJson = "{\n" +
                "  \"name\": \"esmkubraa\",\n" +
                "  \"photoUrls\": [\n" +
                "    \"photoUrls89\"\n" +
                "  ],\n" +
                "  \"id\": 1230,\n" +
                "  \"category\": {\n" +
                "    \"id\": 223,\n" +
                "    \"name\": \"name89\"\n" +
                "  },\n" +
                "  \"tags\": [\n" +
                "    {\n" +
                "      \"id\": 204,\n" +
                "      \"name\": \"name89\"\n" +
                "    }\n" +
                "  ],\n" +
                "  \"status\": \"available\"\n" +
                "}";

        //put işleminin kod kısmını yazdım
        response = given().log().all().header("Content-Type",ContentType.JSON).body(updatePetJson)
                .when().put("/pet")
                .then().log().all()
                .assertThat().statusCode(200)
                .extract().response();

        //güncellediğim yapıyı get methoduyla çağıracağım
        id = response.jsonPath().getInt("id");
        Response getResponse = given().log().all()
                .when().get("/pet/"+id)
                .then().assertThat().statusCode(200)
                .extract().response();
        getResponse.prettyPrint();


    }
}
