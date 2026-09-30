package com.testCases.qa.demo;

import java.io.File;
import java.io.FileInputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class BaseClass {
	
public static WebDriver driver;
public Logger logger;
public Properties prop;
	
	@BeforeClass
	@Parameters({"os","browser"})
	public void setup(@Optional("windows") String os, @Optional("chrome")String br) throws MalformedURLException {
		logger = LogManager.getLogger(this.getClass());
		FileInputStream file = null;
		try {
		prop = new Properties();
		 file= new FileInputStream("C:\\Users\\admin\\eclipse-workspace\\OpenCartAutomation\\src\\main\\resources\\config.properties");
		 prop.load(file);
		}catch(Exception e) {
			e.getStackTrace();
		}
		
		if(prop.getProperty("exceution_env").equalsIgnoreCase("remote")) {
			String hubURL = "http://192.168.1.38:4444/wd/hub";
			DesiredCapabilities cap = new DesiredCapabilities();
			
			//setup os
			//cap.setPlatform(Platform.WIN11);
			if(os.equalsIgnoreCase("windows")) {
				cap.setPlatform(Platform.WIN11);
			}
			else if(os.equalsIgnoreCase("mac"))
			{
				cap.setPlatform(Platform.MAC);
			}
			else {
				System.out.println("invalid Os");
				return;
			}
			//setup browser
			//cap.setBrowserName(br);
			
			switch(br) {
			case "chrome":
				cap.setBrowserName("chrome");
				break;
			case "edge":
				cap.setBrowserName("MicrosoftEdge");
				break;
			default:
				System.out.println("invalid browser!");
				return;
			}
			
			
			
			
			driver = new RemoteWebDriver(new URL(hubURL),cap);
		}
		
		if(prop.getProperty("exceution_env").equalsIgnoreCase("local")) {
			switch(br) {
			case "chrome":
				driver = new ChromeDriver();
				break;
			case "edge":
				driver = new EdgeDriver();
				break;
			case "firefox":
				driver = new FirefoxDriver();
				break;
			default:
				System.out.println("invalid browser!");
				return;
				
			}
		}
		
		
		
		//driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		String url = prop.getProperty("url");
		logger.info(url);
		driver.get(url);
		
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
		
	}
	
	
	public static String captureScreen(String tname) {
		
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		
		TakesScreenshot ts = (TakesScreenshot)driver;
		File src =ts.getScreenshotAs(OutputType.FILE);
		String targetPath = "C:\\Users\\admin\\eclipse-workspace\\OpenCartAutomation\\screenshots\\" + tname +"-"+timeStamp+".png";
		File target = new File(targetPath);
		src.renameTo(target);
		return targetPath;
		
	}

}
