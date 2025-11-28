package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.ElementUtils;

public class HomePage {
	
	WebDriver driver;
	ElementUtils utils;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		utils = new ElementUtils(driver);
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//span[text()='My Account']")
	WebElement myAccountDropMenu;
	
	@FindBy(linkText = "Register")
	WebElement registerOption;
	
	@FindBy(linkText = "Login")
	WebElement loginOption;
	
	@FindBy(name = "search")
	WebElement searchBoxField;
	
	@FindBy(xpath = "//button[@class='btn btn-default btn-lg']")
	WebElement searchButton;
	
	public void clickOnSearchButton() {
		utils.clickOnElement(searchButton);
	}
	
	public void enterProductName(String productText) {
		utils.enterTextIntoTheElement(searchBoxField, productText);
	}
	
	public void selectLoginOption() {
		utils.clickOnElement(loginOption);
	}
	
	public void clickOnMyAccount() {
		utils.clickOnElement(myAccountDropMenu);
	}
	
	public void selectRegisterOption() {
		utils.clickOnElement(registerOption);
	}

}
