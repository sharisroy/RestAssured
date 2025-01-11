package ecomRestAPI;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pojo.Category;
import pojo.LoginRequest;
import pojo.LoginResponse;

import static io.restassured.RestAssured.given;

public class EcommerceRestAPITest {
    LoginResponse loginResponseObj = new LoginResponse();
    String category_id;
    public static void main(String[] args) {



    }
    @BeforeTest
    public void loginTest() {
//        LoginResponse loginResponseObj = new LoginResponse();
        RequestSpecification res = new RequestSpecBuilder().setBaseUri("https://api.freeapi.app")
                .setBasePath("/api/v1/users")
                .setContentType(ContentType.JSON)
                .build();

        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setUsername("haris");
        loginRequest.setPassword("test@123");

        RequestSpecification reqLogin = given().spec(res).body(loginRequest);
        Response loginResponse = reqLogin.when().post("/login").then().statusCode(200)
                .extract().response();


        loginResponseObj.setUsername(loginResponse.jsonPath().getString("data.user.username"));
        loginResponseObj.setEmail(loginResponse.jsonPath().getString("data.user.email"));
        loginResponseObj.setToken(loginResponse.jsonPath().getString("data.accessToken"));
        loginResponseObj.setRefreshToken(loginResponse.jsonPath().getString("data.refreshToken"));

    }
    @Test
    public void createCategory(){
        RequestSpecification res = new RequestSpecBuilder().setBaseUri("https://api.freeapi.app")
                .setBasePath("/api/v1")
                .setContentType(ContentType.JSON)
                .build()
                .cookie("accessToken", loginResponseObj.getToken())
                .cookie("refreshToken", loginResponseObj.getRefreshToken());

        Category category = new Category();
        category.setName("TShirt");

        RequestSpecification reqCategory = given().spec(res).body(category);
        Response categoryResponse = reqCategory.when().post("/ecommerce/categories").then()
                .extract().response();
        System.out.println(categoryResponse.jsonPath().getString("message"));
        category_id = categoryResponse.jsonPath().getString("data._id");



        Response categoryDetails = given().spec(res).get("/ecommerce/categories/" + category_id).then().extract().response();
//        System.out.println(categoryDetails.asString());
        System.out.println(categoryDetails.jsonPath().getString("message"));
        String c_name = categoryDetails.jsonPath().getString("data.name");
        String c_id = categoryDetails.jsonPath().getString("data._id");
        System.out.println("Category Name: \t\t" + c_name);
        System.out.println("Category id: \t\t" + c_id);
    }
}
