package cucumberAPI;

import org.junit.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ApiTestStarWarsPlanetSearch {

	@Test
	public void TC_07_TestVelidData_ApiTestStarWarsPlanetSearch() {

		//  Endpoint/ Base URL specified for all StarWars characters
		
		RestAssured.baseURI = "https://swapi.dev/api/";

		// create request object for type of request
		
		RequestSpecification httpRequest = RestAssured.given();

		// create a response object with Service URL
		
		Response httpResponse = httpRequest.request(Method.GET, "planets/?%name%=%Tatooine%");

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

	@Test
	public void TC_08_TestInvalidInputData_ApiTestStarWarsPlanetSearch() {

		//  Endpoint/ Base URL specified for all StarWars characters
		RestAssured.baseURI = "https://swapi.dev/api/";

		// create request object for type of request
		RequestSpecification httpRequest = RestAssured.given();

		// create a response object with Service URL
		Response httpResponse = httpRequest.request(Method.GET, "planets/61/");

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
	
	@Test
	public void TC_09_TestNullInputData_ApiTestStarWarsPlanetSearch() {

		//  Endpoint/ Base URL specified for all StarWars characters
		RestAssured.baseURI = "https://swapi.dev/api/";

		// create request object for type of request
		RequestSpecification httpRequest = RestAssured.given();

		// create a response object with Service URL
		Response httpResponse = httpRequest.request(Method.GET, "");

		// string response printed
		String myResponse = httpResponse.getBody().asString();
		System.out.println(myResponse);

		// getting status code, printing it and verified Actual result and Expected result is same.// validate status code
		int myStatuscode = httpResponse.getStatusCode();
		System.out.println(myStatuscode);
        Assert.assertEquals(myStatuscode, 200);
		
		// getting status Line, printing it and verified Actual result and Expected result is same.
		String myStatusline = httpResponse.getStatusLine();
		System.out.println(myStatusline);
        
		Assert.assertEquals(myStatusline, "HTTP/1.1 200 OK");

	}

}
