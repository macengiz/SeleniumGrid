package pages;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AmazonPage {
	
	private WebDriver driver;
	
	public AmazonPage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public WebElement twotabsearchtextbox;
	
	@FindBy(xpath="//img[@alt='Product Details']")
	List<WebElement> searchResultItems;
	
	public void goTo(){
		driver.get("https://www.amazon.com");
	}
	
	public void searchFor(String item){
		twotabsearchtextbox.clear();
		twotabsearchtextbox.sendKeys(item + Keys.ENTER);
	}
	
	public boolean atAmazonPage(){
		return driver.getTitle().equals("Amazon.com: Online Shopping for Electronics, Apparel, Computers, Books, DVDs & more");
	}
	
	public boolean resultsAreDisplayed(){
		return searchResultItems!=null && searchResultItems.size() > 0;
	}
	
}
