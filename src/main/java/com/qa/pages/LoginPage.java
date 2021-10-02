package com.qa.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.TestBase.Base;

public class LoginPage extends Base {

	@FindBy(xpath = "//img[contains(@src,'logo')]")
	WebElement logoImage;

	private By headerSections = By.cssSelector("div#navbar-collapse a");

	@FindBy(name = "username")
	WebElement usernameField;

	@FindBy(name = "password")
	WebElement passwordField;

	@FindBy(xpath = "//input[@value='Login']")
	WebElement loginButton;

	public LoginPage() throws Exception {
		PageFactory.initElements(driver, this);
	}

	public boolean isLogoImageDisplayed() {
		return logoImage.isDisplayed();
	}

	public List<String> isHeaderLinksDisplayed() {
		List<String> list = new ArrayList<String>();
		List<WebElement> allHeaderLinks = driver.findElements(headerSections);
		for (WebElement e : allHeaderLinks) {
			String headerList = e.getText();
			list.add(headerList);
		}
		return list;
	}

	public HomePage doLogin(String usrname, String pwd) throws Exception {
		usernameField.sendKeys(usrname);
		passwordField.sendKeys(pwd);
		loginButton.click();
		return new HomePage();
	}

}
