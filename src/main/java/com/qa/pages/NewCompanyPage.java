package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.qa.TestBase.Base;
import com.qa.Utilities.BasicUtilities;

public class NewCompanyPage extends Base {

	@FindBy(xpath = "//legend[text()='Create New  Company']")
	WebElement formHeader;

	@FindBy(id = "company_name")
	WebElement companyNameField;

	@FindBy(name = "industry")
	WebElement industryField;

	@FindBy(id = "annual_revenue")
	WebElement annualRevenueField;

	@FindBy(xpath = "//select[@name='status']")
	WebElement statusField;

	@FindBy(xpath = "//legend[text()='Create New  Company']/following::input[@value = 'Save' and @type = 'submit'][position()='1']")
	WebElement saveButton;

	public NewCompanyPage() throws Exception {
		PageFactory.initElements(driver, this);
	}

	public void createNewCompany(String cmpnyName, String industry, String annualRevenue, String status) {
		companyNameField.sendKeys(cmpnyName);
		industryField.sendKeys(industry);
		annualRevenueField.sendKeys(annualRevenue);
		BasicUtilities.doSelect(statusField, status);
		saveButton.click();
	}

}
