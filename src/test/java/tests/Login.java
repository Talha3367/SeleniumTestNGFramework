package tests;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.Base;
import pages.HomePage;
import pages.LoginPage;
import pages.MyAccountPage;
import utils.CommonUtils;
import utils.MyXLSReader;

public class Login extends Base {

	public WebDriver driver;

	@BeforeMethod
	public void setup() {

		driver = openBrowserAndApplicationPageURL();
		HomePage homePage = new HomePage(driver);
		homePage.clickOnMyAccount();
		homePage.selectLoginOption();

	}

	@AfterMethod
	public void closure() {
		driver.quit();
	}

	@Test(priority = 1,dataProvider="loginCredentailsSupplier")
	public void verifyLoginWithValidCredentials(HashMap<String,String> hMap) {

		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterEmail(hMap.get("Username"));
		loginPage.enterPassword(hMap.get("Password"));
		loginPage.clickOnLoginButton();

		MyAccountPage myAccountPage = new MyAccountPage(driver);
		Assert.assertTrue(myAccountPage.isUserLoggedIn());

	}
	
	@DataProvider
	public Object[][] loginCredentailsSupplier() {
		MyXLSReader myXLSReader = new MyXLSReader("\\src\\test\\resources\\ProjectData.xlsx");
		Object[][] data = CommonUtils.getTestData(myXLSReader,"Login","DataDrivenSheet");
		return data;
	}

	@Test(priority = 2)
	public void verifyLoginWithInvalidCredentails() {

		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterEmail(CommonUtils.generateEmail());
		loginPage.enterPassword(prop.getProperty("invalidPassword"));
		loginPage.clickOnLoginButton();

		Assert.assertTrue(
				loginPage.getWarningMessage().contains("ABCDE Warning: No match for E-Mail Address and/or Password."));

	}

	@Test(priority = 3)
	public void verifyLoginWithValidEmailAndInvalidPassword() {

		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterEmail(prop.getProperty("validEmailTwo"));
		loginPage.enterPassword(prop.getProperty("invalidPassword"));
		loginPage.clickOnLoginButton();

		Assert.assertTrue(
				loginPage.getWarningMessage().contains("Warning: No match for E-Mail Address and/or Password."));

	}

	@Test(priority = 4)
	public void verifyLoginWithInvalidEmailAndValidPassword() {

		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterEmail(CommonUtils.generateEmail());
		loginPage.enterPassword(prop.getProperty("validPassword"));
		loginPage.clickOnLoginButton();

		Assert.assertTrue(
				loginPage.getWarningMessage().contains("Warning: No match for E-Mail Address and/or Password."));

	}

	@Test(priority = 5)
	public void verifyLoginWithoutCredentails() {

		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterEmail("");
		loginPage.enterPassword("");
		loginPage.clickOnLoginButton();

		Assert.assertTrue(
				loginPage.getWarningMessage().contains("Warning: No match for E-Mail Address and/or Password."));

	}

}
