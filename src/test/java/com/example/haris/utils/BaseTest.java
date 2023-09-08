package com.example.haris.utils;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    @BeforeMethod
    public void beforeMethods(){
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
    }
}
