package com.stepdef;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import com.core.WebDriverFactory;
import com.pageobject.HomePage;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CRMstepdef {
	
	
	WebDriver driver;
	String url="https://ui.freecrm.com/";
	
	
	HomePage homepage;
	
	@Before
	public void browser_steup() throws Exception {
		String browsername=WebDriverFactory.get_browser_name();
		driver=WebDriverFactory.browser_selection(browsername);
		
		
		homepage=new HomePage(driver);
	}
	
	
	@After
	public void browser_quit() {
		WebDriverFactory.browser_close();
	}
	
	
	

		@Given("user is already on Login Page")
		public void user_is_already_on_login_page() {
		    WebDriverFactory.navigation_to_url(url);
		}



		@When("title of login page is Free CRM")
		public void title_of_login_page_is_free_crm() {
			String expected_title="Cogmento CRM";
            homepage.validatePageTitleMatch(expected_title);
			System.out.println("Title assertion passed");

		}
		@Then("user enters {string} and {string}")
		public void user_enters_and(String string, String string2) {
		    homepage.login_account(string, string2);
		}
		@Then("user clicks on login button")
		public void user_clicks_on_login_button() {
		    homepage.click_on_login();
		}
		@Then("user is on home page")
		public void user_is_on_home_page() {
			String expected_title="Cogmento CRM";
			homepage.validatePageTitleMatch(expected_title);
			System.out.println("Title assertion passed");
		}
		@Then("user moves to new contact page")
		public void user_moves_to_new_contact_page() throws Exception {
			Thread.sleep(1500);
			Actions actions = new Actions(driver);
            actions.moveToElement(driver.findElement(By.xpath("//span[contains(text(),'Contacts')]"))).perform();
            driver.findElement(By.xpath("//*[@id=\"main-nav\"]/div[3]/a/following-sibling::button/*")).click();
		}
		

			@Then("user enters contact details {string} and {string} and {string}")
			public void user_enters_contact_details_and_and(String firstname, String lastname, String position) throws Exception {
				
				driver.findElement(By.xpath("//input[@name='first_name']")).sendKeys(firstname);
				driver.findElement(By.xpath("//input[@name='last_name']")).sendKeys(lastname);
				driver.findElement(By.name("position")).sendKeys(position);
				//driver.findElement(By.xpath("//button[@class='ui linkedin button']")).click();
				Thread.sleep(2000);
			}

		@Then("Close the browser")
		public void close_the_browser() {
		    WebDriverFactory.browser_close();
		}




}
