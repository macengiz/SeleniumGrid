package SeleniumGrid;

import static org.testng.Assert.assertTrue;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Platform;
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

	public static final String URL = "http://localhost:4444/wd/hub";

	@BeforeTest
	public void setUp() throws MalformedURLException {
		// System.setProperty("webdriver.chrome.driver",
		// "/Users/cybertek/Documents/Libraries/drivers/chromedriver");
		// driver=new ChromeDriver();
		DesiredCapabilities caps = DesiredCapabilities.chrome();
		caps.setPlatform(Platform.ANY);
		// caps.setCapability("platform", "Windows 10");
		// caps.setCapability("version", "60.0");

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
