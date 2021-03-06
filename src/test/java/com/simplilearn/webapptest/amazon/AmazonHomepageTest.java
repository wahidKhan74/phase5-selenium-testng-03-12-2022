package com.simplilearn.webapptest.amazon;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AmazonHomepageTest {

	// step 1: formulate a test url and driver path
	String siteUrl = "https://www.amazon.in/";
	String driverPath = "drivers/geckodriver";
	WebDriver driver;
	
	@BeforeMethod
	public void beforeMethod() {
		System.setProperty("webdriver.gecko.driver", driverPath );
		FirefoxOptions options = new FirefoxOptions();
		options.addArguments("--headless");
		driver = new FirefoxDriver(options);
		// step 4: launch browser
		driver.get(siteUrl);
	}
	
	@AfterMethod
	public void afterMethod() {
		// step 6: close browser
		 driver.close();
	}
	
	@Test
	public void testHomePageTitle() {
		// step5: Evaluating Test
		String expected = "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";
		String actual = driver.getTitle();
		assertEquals(actual, expected);
	}
	
	@Test
	void testHomePageSourceUrl() {
		assertEquals(driver.getCurrentUrl(), siteUrl);
	}
	
	
	@Test
	public void testSearchBar() {
		WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
		searchBox.sendKeys("Iphone 12 max pro");
		searchBox.submit();
		String expected = "Amazon.in : Iphone 12 max pro";
		String actual = driver.getTitle();
		assertEquals(expected, actual);		
		
	}
}
