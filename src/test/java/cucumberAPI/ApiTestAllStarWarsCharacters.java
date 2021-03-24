package cucumberAPI;

import org.junit.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ApiTestAllStarWarsCharacters {
	
	@Test (priority=1)
	public void TC_01_TestVelidData_AllStarWarsCharacters() {

		//  Endpoint/ Base URL specified for all StarWars characters
		
		RestAssured.baseURI = "https://swapi.dev/api/";

		// create request object for type of request
		
		RequestSpecification httpRequest = RestAssured.given();

		// create a response object with Service URL
		Response httpResponse = httpRequest.request(Method.GET, "people/");

		// string response printed
		
		String myResponse = httpResponse.getBody().asString();
		System.out.println(myResponse);

		// getting status code, printing it and verified Actual result and Expected result is same.
		
		int myStatuscode = httpResponse.getStatusCode();
		System.out.println(myStatuscode);
		Assert.assertEquals(myStatuscode, 200);  
		
		// getting status Line, printing it and verified Actual result and Expected result is same.
		
		String myStatusline = httpResponse.getStatusLine();
		System.out.println(myStatusline);
        // Verifying a status Line with Assertion
		Assert.assertEquals(myStatusline, "HTTP/1.1 200 OK");

	}

	@Test (priority=2)
	public void TC_01_TestInvaliddata_AllStarWarsCharacters() {

		//  Endpoint/ Base URL specified for all StarWars characters
		
		RestAssured.baseURI = "https://swapi.dev/api/";

		// create request object for type of request
		
		RequestSpecification httpRequest = RestAssured.given();

		// create a response object with Service URL
		Response httpResponse = httpRequest.request(Method.GET, "people/85/");

		// string response printed
		String myResponse = httpResponse.getBody().asString();
		System.out.println(myResponse);

		// getting status code, printing it and verified Actual result and Expected result is same.
		
		int myStatuscode = httpResponse.getStatusCode();
		System.out.println(myStatuscode);
		Assert.assertEquals(myStatuscode, 404);
		
		// getting status Line, printing it and verified Actual result and Expected result is same.
		
		String myStatusline = httpResponse.getStatusLine();
		System.out.println(myStatusline);
        
		Assert.assertEquals(myStatusline, "HTTP/1.1 404 NOT FOUND");

	}
	
	@Test (priority=3)
	public void TC_03_All_StarWars_char_NullInput() {

		//  Endpoint/ Base URL specified for all StarWars characters
		
		RestAssured.baseURI = "https://swapi.dev/api/";

		// create request object for type of request
		
		RequestSpecification httpRequest = RestAssured.given();

		// create a response object with Service URL
		
		Response httpResponse = httpRequest.request(Method.GET, "");

		// string response printed
		
		String myResponse = httpResponse.getBody().asString();
		System.out.println(myResponse);

		// getting status code, printing it and verified Actual result and Expected result is same.
		
		int myStatuscode = httpResponse.getStatusCode();
		System.out.println(myStatuscode);
        // Verifying a status code with Assertion
		Assert.assertEquals(myStatuscode, 200);
		
		// getting status Line, printing it and verified Actual result and Expected result is same.

		String myStatusline = httpResponse.getStatusLine();
		System.out.println(myStatusline);
        
		Assert.assertEquals(myStatusline, "HTTP/1.1 200 OK");

	}

}
