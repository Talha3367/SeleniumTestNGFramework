package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.ElementUtils;

public class RegisterPage {
	
	WebDriver driver;
	ElementUtils utils;
	
	public RegisterPage(WebDriver driver) {
		this.driver = driver;
		utils = new ElementUtils(driver);
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(id="input-firstname")
	WebElement firstNameField;
	
	public void enterFirstName(String firstNameText) {
		utils.enterTextIntoTheElement(firstNameField, firstNameText);
	}
	
	@FindBy(id="input-lastname")
	WebElement lastNameField;
	
	public void enterLastName(String lastNameText) {
		utils.enterTextIntoTheElement(lastNameField, lastNameText);
	}
	
	@FindBy(id="input-email")
	WebElement emailField;
	
	public void enterEmail(String emailText) {
		utils.enterTextIntoTheElement(emailField, emailText);
	}
	
	@FindBy(id="input-telephone")
	WebElement telephoneField;
	
	public void enterTelephone(String telephoneText) {
		utils.enterTextIntoTheElement(telephoneField, telephoneText);
	}
	
	@FindBy(id="input-password")
	WebElement passwordField;
	
	public void enterPassword(String passwordText) {
		utils.enterTextIntoTheElement(passwordField, passwordText);
	}
	
	@FindBy(id="input-confirm")
	WebElement passwordConfirmField;
	
	public void enterConfirmPassword(String passwordText) {
		utils.enterTextIntoTheElement(passwordConfirmField, passwordText);
	}
	
	@FindBy(name="agree")
	WebElement privacyPolicyField;
	
	public void selectPrivacyPolicyField() {
		utils.clickOnElement(privacyPolicyField);
	}
	
	@FindBy(xpath = "//input[@value='Continue']")
	WebElement continueButton;
	
	public void clickOnContinueButton() {
		utils.clickOnElement(continueButton);
	}
	
	@FindBy(xpath = "//input[@name='newsletter'][@value='1']")
	WebElement yesNewsletterOption;
	
	public void selectYesNewsletterOption() {
		utils.clickOnElement(yesNewsletterOption);
	}

}
