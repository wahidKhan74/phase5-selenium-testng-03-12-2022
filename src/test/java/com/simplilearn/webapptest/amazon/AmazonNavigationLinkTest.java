package com.simplilearn.webapptest.amazon;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AmazonNavigationLinkTest {

	// step 1: formulate a test url and driver path
		String siteUrl = "https://www.amazon.in/";
		String driverPath = "drivers/chromedriver";
		WebDriver driver;
		
		@BeforeMethod
		public void beforeMethod() {
			// step 2: set selenium system properties
			System.setProperty("webdriver.chrome.driver", driverPath);
			// step 3: instantiate selenium web-driver
			driver = new ChromeDriver();
			// step 4: launch browser
			driver.get(siteUrl);
		}
		
		@AfterMethod
		public void afterMethod() {
			// step 6: close browser
			 driver.close();
		}
		
		@Test
		public void testMobileNavLink() throws InterruptedException {
			// find mobile link
			WebElement mobileLink = driver.findElement(By.cssSelector("#nav-xshop > a:nth-child(3)"));
			mobileLink.click();
			String expected ="Mobile Phones: Buy New Mobiles Online at Best Prices in India | Buy Cell Phones Online - Amazon.in";
			String actual = driver.getTitle();
			Thread.sleep(3000);			
			assertEquals(actual, expected);
		
		}
		
		@Test
		public void testBestSellerNavLink() throws InterruptedException {
			// find mobile link
			WebElement sellerLink  = driver.findElement(By.cssSelector("#nav-xshop > a:nth-child(2)"));
			sellerLink .click();
			String expected ="Amazon.in Bestsellers: The most popular items on Amazon";
			String actual = driver.getTitle();
			Thread.sleep(3000);			
			assertEquals(actual, expected);
		
		}
		
		@Test
		public void testElectronicsNavLink() throws InterruptedException {
			// find mobile link
			WebElement electroLink   = driver.findElement(By.cssSelector("#nav-xshop > a:nth-child(6)"));
			electroLink  .click();
			String expected ="Electronics Store: Buy Electronics products Online at Best Prices in India at Amazon.in";
			String actual = driver.getTitle();
			Thread.sleep(3000);			
			assertEquals(actual, expected);
		
		}		
}

