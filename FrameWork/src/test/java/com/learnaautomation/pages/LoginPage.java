package com.learnaautomation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class LoginPage 

{

	WebDriver driver;
	public LoginPage (WebDriver driver)
	
	{
		this.driver=driver;
	}
	

	@FindBy(xpath = "//input[@id='user_login']") WebElement uname;
	@FindBy(xpath = "//input[@id='user_pass']") WebElement pwd;
	@FindBy(xpath = "//input[@id='wp-submit']") WebElement loginButton;
	


public void logn(String username, String Password)
{
	
	try {
		Thread.sleep(3000);
	} catch (Exception e) {
		System.out.println(e.getMessage());
	}
	
	uname.sendKeys(username);
	pwd.sendKeys(Password);
	loginButton.click();
}



}
