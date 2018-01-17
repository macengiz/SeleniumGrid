package pages;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EtsyPage {
	
	private WebDriver driver;
	
	public EtsyPage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public WebElement search_query;
	
	@FindBy(xpath="//img[@class='placeholder placeholder-landscape width-full ']")
	List<WebElement> searchResultItems;
	
	public void goTo(){
		driver.get("https://www.etsy.com");
	}
	
	public void searchFor(String item){
		search_query.clear();
		search_query.sendKeys(item + Keys.ENTER);
	}
	
	public boolean atEtsyPage(){
		return driver.getTitle().equals("Etsy.com | Shop for anything from creative people everywhere");
	}
	
	public boolean resultsAreDisplayed(){
		return searchResultItems!=null && searchResultItems.size() > 0;
	}
	
}
