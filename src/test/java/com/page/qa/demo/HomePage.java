package com.page.qa.demo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.testBase.qa.demo.BasePage;

public class HomePage extends BasePage{
	
	public HomePage(WebDriver driver){
		super(driver);
	}
	
	@FindBy(xpath="//span[text()='My Account']")
	WebElement myaccount;
	
	@FindBy(linkText="Register")
	WebElement registerLink;
	
	@FindBy(linkText="Login")
	WebElement loginLink;
	
	
	public void clickOnMyaccouct() {
		myaccount.click();
	}
	
	public void clickOnRegister() {
		registerLink.click();
	}
	
	public void clickOnLoginLink() {
		loginLink.click();
	}

}
