package activities;

import static io.restassured.RestAssured.given;

import java.io.FileInputStream;
import java.io.IOException;

import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class Activity2 {
	@Test(priority = 1)
	public void addNewUserFromFile() throws IOException{
		//Import JSON file
		FileInputStream inputJSON = new FileInputStream("");
		
		Response response = given()
			.baseUri("https://petstore.swagger.io/v2/pet")
			.header("Content-Type", "application/json")
			.body(inputJSON)
		.when()
			.post();
		inputJSON.close();
		
		response.then().body("code", equalTo(200));
		response.then().body("message", equalTo("5502"));
	}
	@Test(priority = 2)
	public void getUserInfo() {
		
	}

}
