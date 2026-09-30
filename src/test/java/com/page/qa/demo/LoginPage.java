package com.page.qa.demo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.testBase.qa.demo.BasePage;

public class LoginPage extends BasePage{

	public LoginPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(id="input-email")
	WebElement emailInput;
	
	@FindBy(id="input-password")
	WebElement pwdInput;
	
	@FindBy(xpath="//input[@value='Login']")
	WebElement loginBtn;
	
	public void enterUserName(String userEmail)
	{
		emailInput.sendKeys(userEmail);
	}
	
	public void enterPasswrod(String pwd) {
		pwdInput.sendKeys(pwd);
	}
	
	public void clickOnLogin() {
		loginBtn.click();
	}

}
