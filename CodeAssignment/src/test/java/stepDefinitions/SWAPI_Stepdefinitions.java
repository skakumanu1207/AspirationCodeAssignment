package stepDefinitions;

import java.util.ArrayList;

import org.junit.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import org.assertj.core.api.SoftAssertions;

public class SWAPI_Stepdefinitions {

	public Response response;
	public String jsonString;

	@Given("I send the GET request to People end point")
	public void i_send_the_get_request_to_people_end_point() {
		RestAssured.baseURI = "https://swapi.dev/api";
		RequestSpecification request = RestAssured.given();
		response = request.get("/people");
	}

	@Then("Verify the expected response status code is {int}")
	public void verify_the_expected_response_status_code_is(Integer expectedStatusCode) {
		System.out.println("In the response validations step");
		System.out.println(response.statusCode());
		Assert.assertTrue("Status code is not returning as expected", response.statusCode() == expectedStatusCode);
	}

	@Then("Verify the total no of people where height is greater than {string} is equal to {string}")
	public void verify_the_total_no_of_people_where_height_is_greater_than_is_equal_to(String height,
			String expectedNumber) {
		JsonPath js = new JsonPath(response.asString());
		int size = js.getInt("results.size()");
		System.out.println("Results size is: " + size);
		int counter = 0;
		for (int i = 0; i < size; i++) {
			if (Integer.parseInt(js.getString("results[" + i + "].height")) > Integer.parseInt(height)) {
				counter++;
			}
		}
		System.out.println("Total No of People whre Height is greater than " + height + " is " + counter);

		Assert.assertTrue("No Of People is not matching with Expected Height ",
				counter == Integer.parseInt(expectedNumber));
		System.out.println("No Of People is matching with Expected Height");
	}

	@Then("Verify the person names are matching with {string}")
	public void verify_the_person_names_are_matching_with(String namesList) {

		
		String[] expectedNamesArray = namesList.split(",");
		ArrayList<String> expectedNamesList = new ArrayList<String>();
		for (int i = 0; i < expectedNamesArray.length; i++) {
			expectedNamesList.add(expectedNamesArray[i]);
		}

		JsonPath js = new JsonPath(response.asString());
		int size = js.getInt("results.size()");
		System.out.println("Results size is: " + size);

		ArrayList<String> actualNamesList = new ArrayList<String>();
		for (int i = 0; i < size; i++) {
			System.out.println(js.getString("results[" + i + "].name"));
			actualNamesList.add(js.getString("results[" + i + "].name"));
		}
		System.out.println("Actual Names of the List- " + actualNamesList);
		System.out.println("Expected Names of the List- " + expectedNamesList);
		
		for (int i = 0; i < expectedNamesArray.length; i++) {
			Assert.assertTrue(expectedNamesArray[i]+ " is not available in the result Array",actualNamesList.contains(expectedNamesArray[i].trim()));
			System.out.println(expectedNamesArray[i]+ " is available in the result Array");
		}
		
		//With if condition
//		
//		for (int i = 0; i < expectedNamesArray.length; i++) {
//			if(actualNamesList.contains(expectedNamesArray[i].trim()))
//			{
//				System.out.println(expectedNamesArray[i]+ " is available in the result Array");
//			} else
//			{
//				System.out.println(expectedNamesArray[i]+ " is not available in the result Array");
//			}
//					
//		}
	}
	
	@Then("Verify the total no of people checked is {int}")
	public void verify_the_total_no_of_people_checked_is(Integer expectedTotal) {
		JsonPath js = new JsonPath(response.asString());
		int actualTotalCount = js.getInt("count");
		System.out.println("Actual Total Number: " + actualTotalCount);
		
		Assert.assertTrue("Total Count-"+actualTotalCount +" is not matching with expected count-"+expectedTotal,expectedTotal == actualTotalCount);
		System.out.println("Total Count-"+actualTotalCount +" is matching with expected count-"+expectedTotal);
	}
}
