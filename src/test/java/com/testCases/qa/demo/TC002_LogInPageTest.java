package com.testCases.qa.demo;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.page.qa.demo.HomePage;
import com.page.qa.demo.LoginPage;
import com.page.qa.demo.MyAccountPage;
import com.page.qa.demo.MyAccountRegistrationPage;
import com.utilities.qa.demo.DataProviderMethod;

public class TC002_LogInPageTest extends BaseClass {
	
	//@Test(dataProvider ="dp", dataProviderClass=DataProviderMethod.class)
	@Test
	//public void LoginIntoApplication(String username, String pwd, String exp) throws InterruptedException 
	public void LoginIntoApplication() throws InterruptedException 
	{
		logger.info("************Starting the test case TC002 Login into Application******");
		HomePage hp=  new HomePage(driver);
		LoginPage lp = new LoginPage(driver);
		MyAccountPage acc = new MyAccountPage(driver);
		logger.info("Click on the MyAccount link");
		hp.clickOnMyaccouct();
		logger.info("Click on the Login link");
		hp.clickOnLoginLink();
		logger.info("Fiil the login credentials");
		logger.info("Entering username");
		//acc.clickOnLogout();
		//System.out.println(username);
		//System.out.println(pwd);
		//lp.enterUserName(username);
		lp.enterUserName(prop.getProperty("Username"));
		logger.info("Entering password");
		//lp.enterPasswrod(pwd);
		lp.enterPasswrod(prop.getProperty("passowrd"));
		logger.info("Click on Login Button");
		lp.clickOnLogin();
		logger.info("Validating user landed to My account page After logging");
		Assert.assertTrue(acc.naviagtedToMYAccountPage());
		logger.info("Test Case finished !");
		Thread.sleep(5000);
		//acc.clickOnLogout();
			
		
		
	}

}
