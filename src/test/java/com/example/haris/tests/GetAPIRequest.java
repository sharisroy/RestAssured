package com.example.haris.tests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GetAPIRequest {
    @Test
    public void getAllBooking(){
        Response response =
        RestAssured
                .given()
                    .contentType(ContentType.JSON)
                    .baseUri("https://restful-booker.herokuapp.com/booking")
                .when()
                    .get()
                .then()
                    .log().body() // print the request body
                    .assertThat()
                    .statusCode(200)
                    .statusLine("HTTP/1.1 200 OK")
                    .header("Content-Type", "application/json; charset=utf-8")
                .extract()
                .response();

        Assert.assertTrue(response.getBody().asString().contains("bookingid"));



    }
}

