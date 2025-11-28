package tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.Base;
import pages.HomePage;
import pages.SearchResultsPage;

public class Search extends Base {

	public WebDriver driver;

	@BeforeMethod
	public void setup() {

		driver = openBrowserAndApplicationPageURL();

	}

	@AfterMethod
	public void closure() {
		driver.quit();
	}

	@Test(priority = 1)
	public void verifySearchWithExistingProduct() {

		HomePage homePage = new HomePage(driver);
		homePage.enterProductName(prop.getProperty("existingProduct"));
		homePage.clickOnSearchButton();
		SearchResultsPage searchResultsPage = new SearchResultsPage(driver);
		Assert.assertTrue(searchResultsPage.isProductDisplayed());

	}

	@Test(priority = 2)
	public void verifySearchWithNonExistingProduct() {

		HomePage homePage = new HomePage(driver);
		homePage.enterProductName(prop.getProperty("nonExistingProduct"));
		homePage.clickOnSearchButton();
		SearchResultsPage searchResultsPage = new SearchResultsPage(driver);
		Assert.assertEquals(searchResultsPage.getNoProuductMessage(),
				"There is no product that matches the search criteria.");

	}

	@Test(priority = 3)
	public void verifySearchWithoutAnyProduct() {

		HomePage homePage = new HomePage(driver);
		homePage.enterProductName("");
		homePage.clickOnSearchButton();
		SearchResultsPage searchResultsPage = new SearchResultsPage(driver);
		Assert.assertEquals(searchResultsPage.getNoProuductMessage(),
				"There is no product that matches the search criteria.");

	}

}
