package com.example.haris.tests;

import com.example.haris.utils.BaseTest;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.testng.annotations.Test;

public class PostAPIRequest extends BaseTest {
    @Test
    public void createBooking(){


        // request body
        JSONObject booking = new JSONObject();
        JSONObject bookingDates = new JSONObject();

        booking.put("firstname", "First Name - Haris");
        booking.put("lastname", "Last Name - Haris");
        booking.put("totalprice", 1200);
        booking.put("depositpaid", true);
        booking.put("additionalneeds", "Breakfast");
        booking.put("bookingdates",bookingDates);

        bookingDates.put("checkin", "2023-02-22");
        bookingDates.put("checkout", "2023-02-25");
        Response response =
                RestAssured
                .given()
                    .contentType(ContentType.JSON)
                    .body(booking.toString())
                    .baseUri("https://restful-booker.herokuapp.com/booking")
//                    .log().body() // print the request body
                .when()
                    .post()
                .then()
                    .assertThat()
                    .statusCode(200)
                    .body("booking.firstname", Matchers.equalTo("First Name - Haris"))
                    .body("booking.totalprice", Matchers.equalTo(1200))
                    .body("booking.bookingdates.checkin", Matchers.equalTo("2023-02-22"))
                .log().body() // print the response body
//                .log().headers() // print the response header
//                .log().all(); // print the response body header and others
//                    .log().ifValidationFails();
                .extract()
                    .response();

        int bookingId =  response.path("bookingid");
        System.out.println(bookingId);

//        RestAssured
//                .given()
//                    .contentType(ContentType.JSON)
//                    .pathParam("id", bookingId)
//                    .baseUri("https://restful-booker.herokuapp.com/booking")
//                .when()
//                    .get("{bookingId}")
//                .then()
//                    .assertThat()
//                    .statusCode(200);




    }
}
