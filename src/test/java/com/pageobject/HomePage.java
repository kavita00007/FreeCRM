package com.pageobject;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class HomePage {
	
	
	WebDriver driver;

	public HomePage(WebDriver driver) {
		super();
		this.driver = driver;
	}
	
	private By login_email=By.name("email");
	private By login_password=By.name("password");
	private By submit=By.xpath("//div[contains(text(),'Login') and @class='ui fluid large blue submit button']");
	
	
	 
	public void login_account(String username, String password) {
		
		//WebDriverWait wait=new WebDriverWait(driver,20);
		//wait.until(ExpectedConditions.elementToBeClickable(submit));
		driver.findElement(login_email).sendKeys(username);
		driver.findElement(login_password).sendKeys(password);
	}
	
	public void click_on_login() {
		
		driver.findElement(submit).click();
	}

	public void validatePageTitleMatch(String expected_title) {
				WebDriverWait wait = new WebDriverWait(driver, 20);
				Boolean b = wait.until(ExpectedConditions.titleContains(expected_title));
				Assert.assertEquals("Title Validation",true, b);
					
	}

}
