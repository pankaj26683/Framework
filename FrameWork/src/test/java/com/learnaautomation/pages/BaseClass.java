package com.learnaautomation.pages;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;

import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.learnaautomation.Utility.BrowserFactory;
import com.learnaautomation.Utility.ConfigDataProvider;
import com.learnaautomation.Utility.ExcelDataProvider;
import com.learnaautomation.Utility.Helper;

public class BaseClass

{

	public WebDriver driver;
	public ExcelDataProvider excel;// to get the username and password from excel
	public ConfigDataProvider config;// to the the browsertype and url for testing
	public ExtentReports report;// to generate the reports
	public ExtentTest logger;

	@BeforeSuite
	public void ExcelData() {

		excel = new ExcelDataProvider();// to get the username and password from excel
		config = new ConfigDataProvider();// to the the browsertype and url for testing

		// to create the report after test completeion
		ExtentHtmlReporter extent = new ExtentHtmlReporter(
				new File("./Reports/Report_" + Helper.getCurrentTime() + ".html"));
		report = new ExtentReports();
		report.attachReporter(extent);
	}

	@BeforeClass
	public void setup() {
		driver = BrowserFactory.startBrowser(driver, config.getBrowser(), config.getURL());
		System.out.println(driver.getTitle());
	}

	@AfterClass
	public void teardown()// to close the browser after all the operations are completed
	{

		BrowserFactory.quitBrowser(driver);
	}

	@AfterMethod
	public void teardownMethod(ITestResult result) throws IOException // to validate that if tc failed it takes the
																		// screenshot
	{

		if (result.getStatus() == ITestResult.SUCCESS) {
			logger.pass("Test Pass", MediaEntityBuilder.createScreenCaptureFromPath(Helper.screenshot(driver)).build());

		}

		else if (result.getStatus() == ITestResult.FAILURE) {
			logger.fail("Test Failed",
					MediaEntityBuilder.createScreenCaptureFromPath(Helper.screenshot(driver)).build());
		}

		report.flush();// to create the report
		BrowserFactory.quitBrowser(driver);

	}
}
