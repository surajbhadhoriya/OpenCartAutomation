package com.testCases.qa.demo;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.page.qa.demo.HomePage;
import com.page.qa.demo.MyAccountRegistrationPage;

public class TC001_AccountPageTest extends BaseClass{
	
	@Test
	public void createNewAcctount() throws InterruptedException {
		
		try {
		logger.info("************Starting the test case tc001 for new Account creation******");
		HomePage hp=  new HomePage(driver);
		logger.info("Click on the WebElemnt and navigate to the User Register page");
		hp.clickOnMyaccouct();
		hp.clickOnRegister();
		logger.info("Fill the form with User details...");
		MyAccountRegistrationPage acc = new MyAccountRegistrationPage(driver);
		String logo =acc.getRegisterLogo();
		Assert.assertEquals(logo, "Register Account");
		acc.filltheForm();
		Thread.sleep(5000);
		}
		catch(Exception e) {
			logger.error("test case is failed!");
			logger.debug("Debug the failed test case...");
			Assert.fail();
		}
		
		logger.info("Finished Test Case....");
		
	}

}
