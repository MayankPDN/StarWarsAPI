package stepDefinitions;


import java.util.concurrent.TimeUnit;

import org.codehaus.groovy.control.messages.Message;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class APIstepDefination {
	

	WebDriver driver;
	
	@Given("^browser is launched and url is entered for website$")
	public void browser_is_launched_and_url_is_entered_for_website()  {
		System.setProperty("webdriver.chrome.driver","C:\\selenium testing related\\chromedriver.exe");
		 driver=new ChromeDriver();
		 	driver.manage().window().maximize();
		 	driver.manage().deleteAllCookies();
		    driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.get("https://swapi.dev/");
	}
			
	@Then("^user enter valid service URL to search All starwars characters$")
	public void user_enter_valid_service_URL_to_search_All_starwars_characters()  {
			driver.findElement(By.id("interactive")).sendKeys("people/");
	}
	@Then("^user click on Request button$")
	public void user_click_on_Request_button()  {
		driver.findElement(By.xpath("//button[contains(text(),'request')]")).click();
	}
	@Then("^verify the output is displayed$")
	public void verify_the_output_is_displayed()  {
		boolean result = driver.findElement(By.id("interactive_output")).isDisplayed();
		Assert.assertTrue(result);
	}
	@Then("^user enter Invalid service URL to search All starwars characters$")
	public void user_enter_Invalid_service_URL_to_search_All_starwars_characters()  {
		driver.findElement(By.id("interactive")).sendKeys("people/85/");
	}		
	@Then("^user enter Invalid service URL$")
	public void user_enter_Invalid_service_URL()  {
		driver.findElement(By.id("interactive")).sendKeys("people/XYZ1/");
	}
	@Then("^verify the output is not displayed$")
	public void verify_the_output_is_not_displayed()  {
		boolean result = driver.findElement(By.id("interactive_output")).isDisplayed();
		Assert.assertTrue(result);
	}
	@Then("^no service url entered$")
	public void no_service_url_entered()  {
		driver.findElement(By.id("interactive")).click();
	}
	@Then("^enter valid service URL for starwars characters$")
	public void enter_valid_service_URL_for_starwars_characters()  {
		driver.findElement(By.id("interactive")).sendKeys("people/?%name%=%Luke+Skywalker%");
	}
}