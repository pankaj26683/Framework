package com.learnaautomation.testcases;

import org.openqa.selenium.support.PageFactory;

import org.testng.annotations.Test;

import com.learnaautomation.pages.BaseClass;
import com.learnaautomation.pages.LoginPage;

public class LoginTestWordPress extends BaseClass

{

	@Test(priority = 1)
	public void loginAPP() {

		logger = report.createTest("Login to CRM");

//		excel.getNumericdata("Login", 0, 0);
//		excel.getNumericdata("Login", 0, 1);
		LoginPage log = PageFactory.initElements(driver, LoginPage.class);
		logger.info("Starting application");

		log.logn(excel.getStringdata("Login", 0, 0), excel.getStringdata("Login", 0, 1));
		logger.pass("Logged successfully");
		// Helper.screenshot(driver);// to get the screeenshot of success of failure

	}

//	@Test(priority = 2)
//	public void loginAPP1()
//	{
//		
//		
//		logger=report.createTest("Logoutfailed");
//		
//
//		
//		logger.fail("Error at logging out");
//		
//		
//	}
}