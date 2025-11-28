package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.ElementUtils;

public class MyAccountPage {
	
	WebDriver driver;
	ElementUtils utils;
	
	public MyAccountPage(WebDriver driver) {
		this.driver = driver;
		utils = new ElementUtils(driver);
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(linkText = "Edit your account information")
	WebElement editYourAccountInformationOption;
	
	public boolean isUserLoggedIn() {
		return utils.isElementDisplayed(editYourAccountInformationOption);
	}

}
