package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.ElementUtils;

public class LoginPage {

	WebDriver driver;
	ElementUtils utils;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		utils = new ElementUtils(driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "input-email")
	WebElement emailField;
	
	public void enterEmail(String emailText) {
		utils.enterTextIntoTheElement(emailField, emailText);
	}

	@FindBy(id = "input-password")
	WebElement passwordField;
	
	@FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
	WebElement warningMessage;
	
	public String getWarningMessage() {
		return utils.getTextFromElement(warningMessage);
	}
	
	public void enterPassword(String passwordText) {
		utils.enterTextIntoTheElement(passwordField, passwordText);
	}
	
	@FindBy(xpath = "//input[@value='Login']")
	WebElement loginButton;
	
	public void clickOnLoginButton() {
		utils.clickOnElement(loginButton);
	}

}
