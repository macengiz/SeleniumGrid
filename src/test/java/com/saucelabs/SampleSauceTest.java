package com.saucelabs;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
 
import java.net.URL;
 
public class SampleSauceTest {
 
  public static final String USERNAME = "murodil";
  public static final String ACCESS_KEY = "a9097092-9273-485d-bf0a-dd5067958337";
  public static final String URL = "https://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.saucelabs.com:443/wd/hub";
 
 // https://murodil:a9097092-9273-485d-bf0a-dd5067958337@ondemand.saucelabs.com:443/wd/hub
  
  public static void main(String[] args) throws Exception {
 
	  DesiredCapabilities caps = DesiredCapabilities.edge();	  
	  caps.setCapability("platform", "Windows 10");
	  caps.setCapability("version", "15.15063");
 
    WebDriver driver = new RemoteWebDriver(new URL(URL), caps);
    
  //  WebDriver crdriver = new ChromeDriver();
 
    driver.get("https://etsy.com");
    System.out.println("title of page is: " + driver.getTitle());
 
    driver.quit();
  }
}
