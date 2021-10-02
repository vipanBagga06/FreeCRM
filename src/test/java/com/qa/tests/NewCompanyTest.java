package com.qa.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.TestBase.Base;
import com.qa.Utilities.BasicUtilities;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;
import com.qa.pages.NewCompanyPage;

public class NewCompanyTest extends Base{

	public LoginPage loginPage;
	public HomePage homePage;
	public NewCompanyPage newCompanyPage;
	public String sheetName = "NewCompanyData";
	
	public NewCompanyTest() throws Exception {
		super();
	}
	
	@BeforeMethod
	public void setUp() throws Exception {
		initialization();
		loginPage = new LoginPage();
		homePage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		BasicUtilities.switchToFrame();
		newCompanyPage = homePage.clickNewCompanyLink();
	}
	
	@Test(dataProvider = "getData" )
	public void createNewCompanyTest(String company, String industry, String annaulRev, String status) {
		newCompanyPage.createNewCompany(company, industry, annaulRev, status);
	}
	
	@DataProvider
	public Object[][] getData() throws Exception {
		Object[][] data = BasicUtilities.fetchData(sheetName);
		return data;
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
