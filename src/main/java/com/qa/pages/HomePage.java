package com.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.TestBase.Base;
import com.qa.Utilities.BasicUtilities;

public class HomePage extends Base {

	@FindBy(xpath="//td[contains(text(),'group automation')]")
	WebElement userName;
	
	@FindBy(css = "td.logo_text")
	WebElement headerText;
	
	@FindBy(css="div#leftMenuContainer")
	WebElement leftSideContainer;
	
	@FindBy(xpath = "//a[contains(text(),'Setup')]")
	WebElement setUpLink;
	
	@FindBy(xpath = "//td[@class='headertable']/descendant::a[contains(text(),'Help')]")
	WebElement helpLink;
	
	@FindBy(xpath = "//a[contains(text(),'Logout')]")
	WebElement logoutLink;
	
	@FindBy(xpath = "//a[text()='Calendar']")
	WebElement calendarHeaderMenu;
	
	@FindBy(xpath = "//a[text()='Companies']")
	WebElement companiesHeaderMenu;
	
	@FindBy(xpath = "//a[text()='New Company']")
	WebElement newCompanySubMenu;
	
	@FindBy(xpath = "//a[@title='New Event']")
	WebElement newEventSubMenu;
	
	By abc = By.xpath("//a[@title='New Event']");
	
	//initializing the page objects with driver
	public HomePage() throws Exception {
		PageFactory.initElements(driver, this);
	}
	
	public boolean isUserNameDisplayed() {
		return userName.isDisplayed();
	}
	
	public boolean isHeaderTextDisplayed() {
		return headerText.isDisplayed();
	}
	
	public boolean isLeftSideContainerDisplayed() {
		return leftSideContainer.isDisplayed();
	}
	
	public boolean isSetUpLinkDisplayed() {
		return setUpLink.isDisplayed();
	}
	
	public boolean isHelpLinkDisplayed() {
		return helpLink.isDisplayed();
	}

	public boolean isLogoutLinkDisplayed() {
		return logoutLink.isDisplayed();
	}
	
	public boolean isNewEventSubMenuDisplayed() {
		Actions act = new Actions(driver);
		act.moveToElement(calendarHeaderMenu).build().perform();
		BasicUtilities.doWaitForElement(abc);
		return newEventSubMenu.isDisplayed();
	}
	
	public NewCompanyPage clickNewCompanyLink() throws Exception {
		Actions act = new Actions(driver);
		act.moveToElement(companiesHeaderMenu).build().perform();
		newCompanySubMenu.click();
		return new NewCompanyPage();
	}
}
