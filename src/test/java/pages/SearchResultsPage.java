package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.ElementUtils;

public class SearchResultsPage {

	WebDriver driver;
	ElementUtils utils;

	public SearchResultsPage(WebDriver driver) {
		this.driver = driver;
		utils = new ElementUtils(driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(linkText = "HP LP3065")
	WebElement hpProduct;
	
	@FindBy(xpath = "//h2/following-sibling::p")
	WebElement noProductMessage;
	
	public String getNoProuductMessage() {
		return utils.getTextFromElement(noProductMessage);
	}
	
	public boolean isProductDisplayed() {
		return utils.isElementDisplayed(hpProduct);
	}

}
