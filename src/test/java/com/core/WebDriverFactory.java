package com.core;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverFactory {
	
	public static WebDriver driver;

	
	
	public static WebDriver browser_selection(String browser) {
		
		switch(browser.toLowerCase())
		{
		
		case "chrome" : 
		               driver=new ChromeDriver();
		               break;
		               
		case "firefox" :
			           driver=new FirefoxDriver();
			           break;
	     
	     default :    System.out.println("Enter valid browser name");
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		return driver;
	}
	
	public static void navigation_to_url(String url) {
		driver.get(url);
	}
	
	public static void browser_close() {
		driver.quit();
	}
	
	public static void switc_to_window() {
		WebDriverWait wait=new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.numberOfWindowsToBe(2));
		Set<String> handles=driver.getWindowHandles();
		Iterator<String> it=handles.iterator();
		String original=it.next();
        String nextTab = it.next();
        driver.switchTo().window(nextTab);
		
		
	}
	
	public static String get_browser_name() {
		String defaultbrowser="chrome";
		String browserfromcmd=System.getProperty("browser");
		if(browserfromcmd==null)
		{
			return defaultbrowser;
		}
		else return browserfromcmd;
	}

}
