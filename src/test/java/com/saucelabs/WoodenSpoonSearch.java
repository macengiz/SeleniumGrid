package com.saucelabs;

import static org.testng.Assert.assertTrue;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.AmazonPage;
import pages.EtsyPage;

public class WoodenSpoonSearch {

	WebDriver driver;

	public static final String USERNAME = "macengiz";
	public static final String ACCESS_KEY = "c88fa972-1793-43c1-9e0e-ca4deb59cef0";
	public static final String URL = "https://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.saucelabs.com:443/wd/hub";

	@BeforeTest
	public void setUp() throws MalformedURLException {
		// System.setProperty("webdriver.chrome.driver",
		// "/Users/cybertek/Documents/Libraries/drivers/chromedriver");
		// driver=new ChromeDriver();
		DesiredCapabilities caps = DesiredCapabilities.edge();
		caps.setCapability("platform", "Windows 10");
		caps.setCapability("version", "15.15063");

		driver = new RemoteWebDriver(new URL(URL), caps);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@AfterTest
	public void cleanUp() {
		driver.quit();
	}

	@Test
	public void EtsySearchTest() {

		EtsyPage etsy = new EtsyPage(driver);
		etsy.goTo();
		assertTrue(etsy.atEtsyPage());

		etsy.searchFor("Wooden Spoon");
		assertTrue(etsy.resultsAreDisplayed());

	}

	@Test
	public void AmazonSearchTest() {

		AmazonPage amazon = new AmazonPage(driver);
		amazon.goTo();
		assertTrue(amazon.atAmazonPage());

		amazon.searchFor("Wooden Spoon");
		assertTrue(amazon.resultsAreDisplayed());

	}

}
