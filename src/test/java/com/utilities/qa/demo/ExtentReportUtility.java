package com.utilities.qa.demo;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.testCases.qa.demo.BaseClass;

public class ExtentReportUtility implements ITestListener{
	
	public ExtentSparkReporter sparkReporter;
	public ExtentReports extent;
	public ExtentTest test;
	String repName;
	
	public void onStart(ITestContext context) {
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		repName ="Test-Report-"+timeStamp+".html";
		sparkReporter = new ExtentSparkReporter("C:\\Users\\admin\\eclipse-workspace\\OpenCartAutomation\\reports\\"+repName);
		sparkReporter.config().setDocumentTitle("Automation Report");
		sparkReporter.config().setReportName("OpenCart Automation Report");
		sparkReporter.config().setTheme(Theme.DARK);
		
		extent = new ExtentReports();
		extent.attachReporter(sparkReporter);
		
		extent.setSystemInfo("url", "https://tutorialsninja.com/demo/");
		extent.setSystemInfo("Environment", "UAT");
		extent.setSystemInfo("TesterName", "Suraj");
		//extent.setSystemInfo("OS", "Win 11");
		
		String OS = context.getCurrentXmlTest().getParameter("os");
		extent.setSystemInfo("Operating System", OS);
		
		String browser = context.getCurrentXmlTest().getParameter("browser");
		extent.setSystemInfo("Browser", browser);
		
		
		
		
	}
	
	public void onTestSuccess(ITestResult result) {
		test = extent.createTest(result.getTestClass().getName());
		// test.assignCategory(result.getMethod().getGroups());
		 test.log(Status.PASS, result.getName()+"got sucessfully executed");
	}
	
	public void onTestFailure(ITestResult result) {
		test = extent.createTest(result.getTestClass().getName());
		// test.assignCategory(result.getMethod().getGroups());
		 test.log(Status.FAIL, result.getName()+"got Failed");
		 test.log(Status.INFO, result.getThrowable().getMessage());
		 
		 String imgPath = BaseClass.captureScreen(result.getName());
		 test.addScreenCaptureFromPath(imgPath);
	}
	
	public void onTestSkipped(ITestResult result) {
		test = extent.createTest(result.getTestClass().getName());
		// test.assignCategory(result.getMethod().getGroups());
		 test.log(Status.SKIP, result.getName()+"got Skipped");
		 test.log(Status.INFO, result.getThrowable().getMessage());
	}
	
	public void onFinish(ITestContext context) {
		extent.flush();
		/*
		String path = "C:\\Users\\admin\\eclipse-workspace\\OpenCartAutomation\\reports\\"+repName;
		File extentReport = new File(path);
		
		try {
			Desktop.getDesktop().browse(extentReport.toURI());
		}catch(IOException e) {
			e.printStackTrace();
		}
		*/
	}
	

}
