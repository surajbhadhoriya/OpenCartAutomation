package com.page.qa.demo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.testBase.qa.demo.BasePage;

public class MyAccountRegistrationPage extends BasePage{

	public MyAccountRegistrationPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath="//h1[normalize-space()='Register Account']")
	WebElement regAccLogo;
	
	@FindBy(id="input-firstname")
	WebElement fname;
	
	@FindBy(id="input-lastname")
	WebElement lname;
	
	@FindBy(id="input-email")
	WebElement email;
	
	@FindBy(id="input-telephone")
	WebElement phone;
	
	@FindBy(id="input-password")
	WebElement pwd;
	
	@FindBy(id="input-confirm")
	WebElement cpwd;
	
	@FindBy(xpath="//input[@name='agree']")
	WebElement checkbox;
	
	@FindBy(xpath="//input[@value='Continue']")
	WebElement submitBtn;
	
	
	
	
	public String getRegisterLogo() {
		return regAccLogo.getText();
	}
	
	
	public void filltheForm() {
		fname.sendKeys("Test");
		lname.sendKeys("Demo");
		email.sendKeys("TestAuraj123Demo@mailinator.com");
		phone.sendKeys("9192939495");
		pwd.sendKeys("TestDemo@123");
		cpwd.sendKeys("TestDemo@123");
		checkbox.click();
		submitBtn.click();
		
		
	}
	
	
	

}
