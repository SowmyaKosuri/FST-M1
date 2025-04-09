package activities;

import static org.hamcrest.Matchers.lessThanOrEqualTo;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class Activity3 {
	//Declare request specification
	RequestSpecification requestSpec;
	//Declare response specification
	ResponseSpecification responseSpec;
	
	@BeforeClass
	public void setUp() {
		// Create request specification
		requestSpec = new RequestSpecBuilder()
			.setBaseUri("https://petstore.swagger.io/v2/pet")
			.addHeader("Content-Type", "application/json")
			.build();
		
		// Create response specification
		responseSpec = new ResponseSpecBuilder()
				.expectStatusCode(200)
				.expectContentType(ContentType.JSON)
				.expectResponseTime(lessThanOrEqualTo(5000L))  //SLA Assertion)
				.build();
		
	}
	@DataProvider(name="petInfo")
	public Object[][] petInfoProvider(){
		//Setting parameters to pass to test case
		Object[][] testData = new Object[][] { 
			{ 79132, "Raily", "alive" }, 
			{ 79133, "Hansal", "alive" }
		};
		return testData;
	}
	@Test(priority = 1,dataProvider = "petInfo")
	//testcase using DataProvider
	public void addPets(int petId, String petName, String petStatus) {
		Map<String, Object> reqBody = new HashMap<>();
		reqBody.put("id", petId);
		reqBody.put("name", petName);
		reqBody.put("status", petStatus);
		
		given().spec(requestSpec) // Use requestSpec
			.body(reqBody) // Send request body
		.when()
			.post() // Send POST request
		.then().spec(responseSpec) // Assertions using responseSpec
		.body("name", equalTo(petName)); // Additional Assertion
	}
	// Test case using a DataProvider
		@Test( priority=2, dataProvider = "petInfo")
		public void getPets(int petId, String petName, String petStatus) {
			given().spec(requestSpec) // Use requestSpec
				.pathParam("petId", petId) // Add path parameter
				.log().all() // Log for request details
			.when()
				.get("/{petId}") // Send GET request
			.then().spec(responseSpec) // Assertions using responseSpec
			    .body("name", equalTo(petName)) // Additional Assertion
			    .log().all(); // Log for request details
		}
		// Test case using a DataProvider
		@Test(priority=3, dataProvider = "petInfo")
		public void deletePets(int petId, String petName, String petStatus) {
			given().spec(requestSpec) // Use requestSpec
				.pathParam("petId", petId) // Add path parameter
			.when()
				.delete("/{petId}") // Send GET request
			.then()
				.body("code", equalTo(200))
				.body("message", equalTo(""+petId)); // Assertions using responseSpec
		}
		
}
