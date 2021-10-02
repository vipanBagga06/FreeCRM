package com.qa.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.TestBase.Base;
import com.qa.Utilities.BasicUtilities;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;
import com.qa.pages.NewCompanyPage;

public class HomePageTest extends Base{

	public HomePage homePage;
	public LoginPage loginPage;
	public NewCompanyPage newCompanyPage;
	
	public HomePageTest() throws Exception {
		super();
	}
	
	
	@BeforeMethod
	public void setUp() throws Exception {
		initialization();
		loginPage = new LoginPage();
		homePage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		BasicUtilities.switchToFrame();
	}
	
	@Test(priority = 1)
	public void verifyUserNameDisplayedTest() {
		boolean isUserNameDisplayed = homePage.isUserNameDisplayed();
		Assert.assertTrue(isUserNameDisplayed, "Logged in User name is not displayed on Home Page");
	}
	
	@Test(priority = 2)
	public void verifyHeaderTextDisplayedTest() {
		boolean isHeaderTextDisplayed = homePage.isHeaderTextDisplayed();
		Assert.assertTrue(isHeaderTextDisplayed, "Header Text is not displayed on Home Page");
	}
	
	@Test(priority = 3)
	public void verifyLeftSideContainerTest() {
		boolean isLeftSideContainerDisplayed = homePage.isLeftSideContainerDisplayed();
		Assert.assertTrue(isLeftSideContainerDisplayed, "Left Container is not displayed on Home Page");
	}
	
	@Test(priority = 4)
	public void verifySetUpLinkTest() {
		boolean isSetUpLinkDisplayed = homePage.isSetUpLinkDisplayed();
		Assert.assertTrue(isSetUpLinkDisplayed, "Set Up Link is not displayed on Home Page");
	}
	
	@Test(priority = 5)
	public void verifyHelpLinkTest() {
		boolean isHelpLinkDisplayed = homePage.isHelpLinkDisplayed();
		Assert.assertTrue(isHelpLinkDisplayed, "Help Link is not displayed on Home Page");
	}
	
	@Test(priority = 6)
	public void verifyLogoutLinkTest() {
		boolean isLogoutLinkDisplayed = homePage.isLogoutLinkDisplayed();
		Assert.assertTrue(isLogoutLinkDisplayed, "Logout Link is not displayed on Home Page");
	}
	
	@Test(priority = 7)
	public void verifyNewEventSubMenuTest() {
		boolean isNewEventSubMenuDisplayed = homePage.isNewEventSubMenuDisplayed();
		Assert.assertTrue(isNewEventSubMenuDisplayed, "New Event Sub Menu is not displayed under Calendar Header Menu on Home Page");
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

	
}
