package com.qa.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.AssertJUnit;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.TestBase.Base;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;

public class LoginPageTest extends Base {

	public LoginPage loginPage;
	public HomePage homePage;

	public LoginPageTest() throws Exception {
		super();
	}

	@BeforeMethod
	public void setUp() throws Exception {
		initialization();
		loginPage = new LoginPage();
	}

	@Test(priority = 1)
	public void verifyLoginPageLogoTest() {
		boolean isLogoImageDisplayed = loginPage.isLogoImageDisplayed();
		Assert.assertTrue(isLogoImageDisplayed, "Logo Image is not displayed");
	}

	@Test(priority = 2)
	public void verifyHeaderLinksTest() {
		List<String> headerLinks = loginPage.isHeaderLinksDisplayed();
		for (String list : headerLinks) {
			System.out.println(list);
		}
	}

	@Test(priority = 3)
	public void loginTest() throws Exception {
		homePage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
