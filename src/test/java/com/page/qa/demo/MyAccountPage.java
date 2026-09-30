package com.page.qa.demo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.testBase.qa.demo.BasePage;

public class MyAccountPage extends BasePage {

	public MyAccountPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(linkText="Account")
	WebElement accountConfirmation;
	
	@FindBy(linkText="Logout")
	WebElement logoutLink;
	
	public boolean naviagtedToMYAccountPage() {
		return accountConfirmation.isDisplayed();
	}
	
	public void clickOnLogout() {
		logoutLink.click();
	}

}
